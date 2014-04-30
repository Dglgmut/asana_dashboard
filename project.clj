(defproject asana-dashboard "0.0.1"
  :description "A simple stand-alone webapp"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [cheshire "5.3.1"]
                 [org.clojure/clojurescript "0.0-2202"]
                 [clj-http "0.9.1"]
                 [joodo "1.1.2"]]
  :min-lein-version "2.0.0"

  :joodo-root-namespace asana-dashboard.root

  :profiles {:dev {:dependencies [[speclj "2.6.1"]]}}
  :test-paths ["spec/"]
  :java-source-paths ["src/"]
  :plugins [[speclj "2.6.1"]
            [joodo/lein-joodo "1.1.2"]
            [lein-cljsbuild "1.0.3"]]

  )
  :cljsbuild {
    :builds [{
      :source-paths ["src-cljs"]}]}
