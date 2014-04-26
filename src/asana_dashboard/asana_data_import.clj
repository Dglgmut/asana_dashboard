(ns asana_dashboard.asana-data-import
  (:require [clj-http.client :as client]))

(defn get_asana_page
  [url]
  (client/get url))
