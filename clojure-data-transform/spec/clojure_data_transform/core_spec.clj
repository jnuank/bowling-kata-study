(ns clojure-data-transform.core-spec
  (:require [clojure-data-transform.core :refer [game-score per-frame-rolls]]
            [speclj.core :refer [describe it should=]]))

(describe "game-score"
          (it "全部ガーター"
              (should= 0 (game-score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))
          
          (it "全部ストライク"
              (should= 300 (game-score [10 10 10 10 10 10 10 10 10 10 10 10])))
          
          (it "全部スペア"
              (should= 150 (game-score [5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5])))
          )

(describe "per-frame-rolls"
          (it "全部ガーター"
              (should= [[0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0]]
                       (per-frame-rolls [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))
          
          (it "最初ストライク"
              (should= [[10] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0]]
                       (per-frame-rolls [10 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))
          
          (it "最終フレームストライクボーナス"
              (should= [[0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [10 10 10]]
                       (per-frame-rolls [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10 10 10])))
          
          (it "最終フレームスペアボーナス"
              (should= [[0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [4 6 5]]
                       (per-frame-rolls [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 4 6 5])))
          )