(doctype :html5)
[:html
 [:head
  [:meta {:http-equiv "Content-Type" :content "text/html" :charset "iso-8859-1"}]
  [:title "asana-dashboard"]
  (include-css "/stylesheets/asana_dashboard.css")
  (include-js "/javascript/asana_dashboard.js")]
 [:body
  (eval (:template-body joodo.views/*view-context*))
]]