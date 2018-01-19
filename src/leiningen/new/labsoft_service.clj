(ns leiningen.new.labsoft-service
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files sanitize-ns project-name]]
            [leiningen.core.main :as main]))

(def render (renderer "labsoft-service"))
(def identity-render (renderer "labsoft-service" identity))

(defn labsoft-service
  "Generate a new labsoft micro-service"
  [name]
  (let [sanitized-ns (sanitize-ns name)
        data {:raw-name name
              :name (project-name name)
              :namespace sanitized-ns
              :sanitized (name-to-path sanitized-ns)
              :namespace-set (str "'#{" namespace "}")
              :http-port (+ 8001 (rand-int 999))}]
    (main/info "Generating fresh 'lein new' labsoft-service project.")
    (->files data
             [".circleci/config.yml" (identity-render "circleci_config.yml")]
             ["README.md" (render "README.md" data)]
             ["project.clj" (render "project.clj" data)]
             [".gitignore" (render ".gitignore" data)]
             ["Dockerfile" (render "Dockerfile" data)]
             ["src/{{sanitized}}/service.clj" (render "service.clj" data)]
             ["src/{{sanitized}}/routes.clj" (render "routes.clj" data)]
             ["src/{{sanitized}}/components.clj" (render "components.clj" data)]
             ["src/{{sanitized}}/db/datomic/config.clj" (render "datomic_config.clj" data)]
             ["src/{{sanitized}}/diplomat/sqs.clj" (render "sqs.clj" data)]
             ["test/{{sanitized}}/service_test.clj" (render "service_test.clj" data)]
             ["test/{{sanitized}}/aux/test_helpers.clj" (render "test_helpers.clj" data)]
             ["resources/logback.xml" (render "logback.xml" data)]
             ["resources/dev_config.json" (render "dev_config.json" data)]
             ["resources/prod_config.json" (render "prod_config.json" data)])))
