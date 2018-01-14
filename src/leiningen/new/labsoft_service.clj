(ns leiningen.new.labsoft-service
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files sanitize-ns project-name]]
            [leiningen.core.main :as main]))

(def render (renderer "labsoft-service"))

(defn labsoft-service
  "Generate a new labsoft micro-service"
  [name]
  (let [sanitized-ns (sanitize-ns name)
        data {:raw-name name
              :name (project-name name)
              :namespace sanitized-ns
              :sanitized (name-to-path sanitized-ns)
              :namespace-set (str "'#{" namespace "}")}]
    (main/info "Generating fresh 'lein new' labsoft-service project.")
    (->files data
             ["README.md" (render "README.md" data)]
             ["project.clj" (render "project.clj" data)]
             [".gitignore" (render ".gitignore" data)]
             ["Dockerfile" (render "Dockerfile" data)]
             ["src/{{sanitized}}/service.clj" (render "service.clj" data)]
             ["src/{{sanitized}}/routes.clj" (render "routes.clj" data)]
             ["test/{{sanitized}}/service_test.clj" (render "service_test.clj" data)]
             ["test/{{sanitized}}/aux/test_helpers.clj" (render "test_helpers.clj" data)]
             ["resources/logback.xml" (render "logback.xml" data)]
             ["resources/dev_config.json" (render "dev_config.json" data)]
             ["resources/prod_config.json" (render "prod_config.json" data)])))
