(ns clojure-data-transform.core-spec
  (:require [clojure-data-transform.core :refer [score]]
            [speclj.core :refer [describe it should=]]))

(describe "score"
          (it "全部ガーター"
              (should= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))
