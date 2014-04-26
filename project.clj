(defproject asana_dashboard "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://asana_dashboard.herokuapp.com"
  :license {:name "FIXME: choose"
            :url "http://example.com/FIXME"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.1"]
                 [ring "1.2.2"]
                 [ring-basic-authentication "1.0.1"]
                 [environ "0.2.1"]
                 [com.cemerick/drawbridge "0.0.6"]]
  :min-lein-version "2.0.0"
  :plugins [[environ/environ.lein "0.2.1"]
            [lein-ring "0.8.10"]]
  :hooks [environ.leiningen.hooks]
  :profiles {:production {:env {:production true}}}
  :ring {:handler asana_dashboard.web/app})
