(ns asana_dashboard.asana-data-import
  (:require [clj-http.client :as client]
            [cheshire.core :refer :all]))

(defn get-asana-page
  [api-path auth-token]
  (client/get
    (str "https://app.asana.com/api/1.0/"
         api-path)
    {:basic-auth (str auth-token ":")}))

(defn get-me
  [auth-token]
  (parse-string
    (:body (get-asana-page "users/me" auth-token)) true))
