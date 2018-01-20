(ns {{namespace}}.service-test
  (:require [midje.sweet :refer :all]
            [{{namespace}}.aux.init :as init]))

(def service (init/test-service))

(fact "Http Test"
  (th/request! service :get "/") => {:res "Hello, World!"})
