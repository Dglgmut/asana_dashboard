(ns asana-dashboard.lib
  (:require [clj-http.client :as client]
            [cheshire.core :refer :all]))

(defn get-asana-page [api-path auth-token]
  (client/get
    (str "https://app.asana.com/api/1.0/"
         api-path)
    {:basic-auth (str auth-token ":")}))

(defn get-me [auth-token]
  (parse-string
    (:body (get-asana-page "users/me" auth-token)) true))

(defn get-first-workspace [auth-token]
  (get (:workspaces (:data (get-me auth-token))) 0))

(defn get-tasks-from-me [auth-token]
  (parse-string
    (:body (get-asana-page 
             (str "tasks/" 
                  "?workspace=" (:id (get-first-workspace auth-token))
                  "&assignee=" "me");Here we can get project related if we want to
             auth-token)) true))

(defn get-tasks-ids [auth-token]
  (map :id (:data (get-tasks-from-me auth-token))))

(defn parse-int [string]
  (Integer. (re-find #"\d+" string)))

(defn get-tasks-points [auth-token]
  (map parse-int (map :name (:data (get-tasks-from-me auth-token)))))
