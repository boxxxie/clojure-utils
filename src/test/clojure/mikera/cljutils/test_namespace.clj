(ns mikera.cljutils.test-namespace
  (:use clojure.test)
  (:require [mikera.cljutils.namespace :as n])
  (:require [mikera.cljutils.dummy]))

(n/clone 'mikera.cljutils.dummy)

(deftest test-with-ns
  (testing "use existing ns"
    (is (= 9 (n/with-ns 'mikera.cljutils.dummy dummy-bar))))
  (testing "cloned within ns"
    (is (= 9 dummy-bar))))
