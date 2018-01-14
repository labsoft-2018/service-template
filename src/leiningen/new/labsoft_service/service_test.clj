(ns {{namespace}}.service-test
  (:require [midje.sweet :refer :all]
            [{{namespace}}.aux.test-helpers :as th]))

(def service (th/test-service))

(fact "Http Test"
  (th/request! service :get "/") => {:res "Hello, World!"})
