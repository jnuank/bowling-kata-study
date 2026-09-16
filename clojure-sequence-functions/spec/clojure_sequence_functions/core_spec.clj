(ns clojure-sequence-functions.core-spec
  (:require [speclj.core :refer :all]
            [clojure-sequence-functions.core :refer :all]))

(describe "core"
  (it "should return the first element of a sequence"
    (should= 1 (first [1 2 3]))))