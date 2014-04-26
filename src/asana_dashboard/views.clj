(ns asana_dashboard.views
  (:require [clojure.string :as str]
            [hiccup.page :as hic]
            [hiccup.form :as form]))

(defn generate-page-head
  [title]
  [:head
    [:title (str "Location: " title)]
    (hic/include-css "/css/styles.css")])

(defn form-fields
  []
  [:div {:id "asana-form"}
  (form/label "asana-token" "Asana Token:")
  (form/text-field "asana-token")
  (form/submit-button :submit)])

(defn home-page
  []
  (hic/html5
    (generate-page-head "Home Page")
    [:h1 "Howdy, enter your asana token in order to see the dashboard"]
    (form-fields)))
