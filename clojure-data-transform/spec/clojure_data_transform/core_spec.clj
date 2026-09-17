(ns clojure-data-transform.core-spec
  (:require [clojure-data-transform.core :refer [score frames]]
            [speclj.core :refer [describe it should=]]))

(describe "score"
          (it "全部ガーター"
              (should= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))

(describe "frames"
          (it "全部ガーター"
              (should= [[0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0]]
                       (frames [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))