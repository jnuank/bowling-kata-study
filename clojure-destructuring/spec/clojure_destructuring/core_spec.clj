(ns clojure-destructuring.core-spec
  (:require [clojure-destructuring.core :refer [score]]
            [speclj.core :refer [describe, it, should=]]))

(describe "score"
          (it "全フレーム 9pin"
              (should= 90 (score [9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0]))))