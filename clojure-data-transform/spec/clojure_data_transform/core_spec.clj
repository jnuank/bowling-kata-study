(ns clojure-data-transform.core-spec
  (:require [clojure-data-transform.core :refer [game-score per-frame-rolls]]
            [speclj.core :refer [describe it should=]]))

(describe "game-score"
          (it "全部ガーター"
              (should= 0 (game-score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))

(describe "per-frame-rolls"
          (it "全部ガーター"
              (should= [[0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0]]
                       (per-frame-rolls [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))
          
          (it "最初ストライク"
              (should= [[10] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0]]
                       (per-frame-rolls [10 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))
          )