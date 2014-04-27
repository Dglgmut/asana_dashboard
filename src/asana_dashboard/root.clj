(ns asana-dashboard.root
  (:use
    [compojure.core :only (defroutes GET POST)]
    [compojure.route :only (not-found)]
    [joodo.middleware.view-context :only (wrap-view-context)]
    [joodo.views :only (render-template render-html)]
    [joodo.controllers :only (controller-router)]))

(defroutes asana-dashboard-routes
  (GET "/" [] (render-template "index"))
  (POST "/" {:as req} (str req))
  (controller-router 'asana-dashboard.controller)
  (not-found (render-template "not_found" :template-root "asana_dashboard/view" :ns `asana-dashboard.view.view-helpers)))

(def app-handler
  (->
    asana-dashboard-routes
    (wrap-view-context :template-root "asana_dashboard/view" :ns `asana-dashboard.view.view-helpers)))

