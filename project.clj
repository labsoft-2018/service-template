(defproject labsoft-service/lein-template "0.6.3"
  :description "Template for creating microservices using common-labsoft"
  :url "https://github.com/labsoft-2018/labsoft-service-template"
  :deploy-repositories [["clojars" {:url      "https://clojars.org/repo"
                                    :username :env/clojars_username
                                    :password :env/clojars_password
                                    :sign-releases false}]]
  :license {}
  :eval-in-leiningen true)
