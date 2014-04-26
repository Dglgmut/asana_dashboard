(ns asana_dashboard.views
  (:require [clojure.string :as str]
            [hiccup.page :as hic]))

(defn generate-page-head
  [title]
  [:head
    [:title (str "Location: " title)]
    (hic/include-css "/css/styles.css")])

(defn home-page
  []
  (hic/html5
    (generate-page-head "Home Page")
    [:h1 "Howdy"]))
