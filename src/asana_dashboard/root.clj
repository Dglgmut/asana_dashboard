(ns asana-dashboard.root
  (:use
    [asana-dashboard.lib]
    [compojure.core :only (defroutes GET POST)]
    [compojure.route :only (not-found)]
    [joodo.middleware.view-context :only (wrap-view-context)]
    [joodo.views :only (render-template render-html)]))

(defroutes asana-dashboard-routes
  (GET "/" [] (render-template "index"))
  (POST "/" {params :params} 
    (render-template "dashboard"
                     :name (:name (:data (get-me (:asana-token params))))
                     :total-tasks-points (get-total-tasks-points (:asana-token params))
                     :total-completed-tasks-points (get-total-completed-tasks-points (:asana-token params)) ))
  (not-found (render-template "not_found" :template-root "asana_dashboard/view" :ns `asana-dashboard.view.view-helpers)))

(def app-handler
  (->
    asana-dashboard-routes
    (wrap-view-context :template-root "asana_dashboard/view" :ns `asana-dashboard.view.view-helpers)))

