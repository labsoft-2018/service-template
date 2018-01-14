(defproject {{raw-name}} "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "All Rights Reserved"}
  :plugins [[lein-midje "3.2.1"]]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [labsoft-2018/common-labsoft "0.1.2-SNAPSHOT"]]
  :resource-paths ["resources"]
  :aot [{{namespace}}.service]
  :main {{namespace}}.service)
