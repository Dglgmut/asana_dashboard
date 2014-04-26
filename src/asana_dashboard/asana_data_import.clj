(ns asana_dashboard.asana-data-import
  (:require [clj-http.client :as client]))

(defn get-asana-page
  [api-path auth-token]
  (client/get
    (str "https://app.asana.com/api/1.0/"
         api-path)
    {:basic-auth (str auth-token ":")}))
