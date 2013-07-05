(ns mikera.cljutils.test-error
  (:use clojure.test)
  (:use [mikera.cljutils macros]))

(deftest test-and-as
  (testing "Basic results"
    (is (= 1 (and-as-> 1 x)))
    (is (= nil (and-as-> nil x)))
    (is (= nil (and-as-> nil x 
                         x 
                         x)))
    (is (= 1 (and-as-> nil x 
                       1))))
  (testing "Sequential results"
    (is (== 3 (and-as-> 1 x 
                        (inc x) 
                        (inc x))))
    (is (== nil (and-as-> 1 x 
                          (inc x) 
                          nil 
                          (inc x)))))
  (testing "Falsiness"
    (is (== false (and-as-> 1 x 
                            false 
                            true)))
    (is (== true (and-as-> false x 
                           true 
                           false)))))

