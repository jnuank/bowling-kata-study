(ns clojure-sequence-functions.core-spec
  (:require [speclj.core :refer [describe it should=]]
            [clojure-sequence-functions.core :refer [score]]))

(describe "core"
          (it "should return the first element of a sequence"
              (should= 1 (first [1 2 3]))))


(describe "score"
          (it "全フレーム9ピン"
              (should= 90 (score [9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0])))
          
          (it "全フレームスペア"
              (should= 150 (score [5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5]))))
