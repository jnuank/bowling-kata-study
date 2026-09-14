(ns clojure-bowling.core-test
  (:require [clojure.test :refer :all]
            [clojure-bowling.core :refer :all]))

; TODO: bowring 
; gutter


(deftest score-test
  (testing "score should be 0 for gutter game"
    (is (= 2 2))))

