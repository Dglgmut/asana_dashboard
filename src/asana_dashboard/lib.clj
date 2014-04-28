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

;
(defn query-for-tasks [auth-token query]
  (parse-string
    (:body (get-asana-page
             (str "tasks/" query )
             auth-token)) true))

;TODO replace 'me' with something else
(defn get-tasks-from-me [auth-token]
  (query-for-tasks auth-token (str "?workspace=" (:id (get-first-workspace auth-token))
                                   "&assignee=" "me")));Here we can get project related if we want to
(defn get-not-completed-tasks-from-me [auth-token]
  (query-for-tasks auth-token (str "?workspace=" (:id (get-first-workspace auth-token))
                                   "&completed_since=" "2015-01-01T00:00:00.000Z" ;TODO replace this with a sprint time
                                   "&assignee=" "me")))

(defn get-tasks-ids [auth-token]
  (map :id (:data (get-tasks-from-me auth-token))))

;
(defn parse-int [string]
  (Integer. (re-find #"\d+" string)))
;
(defn sum-points [obj]
  (reduce + (map parse-int (map :name (:data obj)))))


(defn get-total-tasks-points [auth-token]
  (sum-points (get-tasks-from-me auth-token)))

(defn get-total-not-completed-tasks-points [auth-token]
  (sum-points (get-not-completed-tasks-from-me auth-token)))

(defn get-total-completed-tasks-points [auth-token]
  (reduce - [(get-total-tasks-points auth-token) (get-total-not-completed-tasks-points auth-token)]))

