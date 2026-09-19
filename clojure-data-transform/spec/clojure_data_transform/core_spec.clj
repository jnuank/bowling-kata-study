(ns clojure-data-transform.core-spec
  (:require [clojure-data-transform.core :refer [game-score
                                                 scoring-rolls-per-frame]]
            [speclj.core :refer [describe it should=]]))

(describe "scoring-rolls-per-frame"
          (it "全部ガーター"
              (should= [[0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0]]
                       (scoring-rolls-per-frame [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))

          (it "全部ストライク"
              (should= [[10 10 10] [10 10 10] [10 10 10] [10 10 10] [10 10 10]
                        [10 10 10] [10 10 10] [10 10 10] [10 10 10] [10 10 10]]
                       (scoring-rolls-per-frame [10 10 10 10 10 10 10 10 10 10 10 10])))

          (it "全部スペア"
              (should= [[5 5 5] [5 5 5] [5 5 5] [5 5 5] [5 5 5] [5 5 5] [5 5 5] [5 5 5] [5 5 5] [5 5 5]]
                       (scoring-rolls-per-frame [5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5])))

          (it "1フレームがストライク、2フレーム目がオープン、ほかはガーター"
              (should= [[10 4 5] [4 5] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0]]
                       (scoring-rolls-per-frame [10 4 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))

          (it "1フレームがスペア、2フレーム目がオープン、ほかはガーター"
              (should= [[5 5 3] [3 4] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0]]
                       (scoring-rolls-per-frame [5 5 3 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))

          (it "10フレーム目だけストライク"
              (should= [[0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [10 3 4]]
                       (scoring-rolls-per-frame [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10 3 4])))

          (it "10フレーム目だけスペア"
              (should= [[0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [7 3 6]]
                       (scoring-rolls-per-frame [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7 3 6]))))


(describe "game-score"
          (it "全部ガーター"
              (should= 0 (game-score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))

          (it "全部ストライク"
              (should= 300 (game-score [10 10 10 10 10 10 10 10 10 10 10 10])))

          (it "全部スペア"
              (should= 150 (game-score [5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5])))

          (it "1フレームがストライク、2フレーム目がオープン、ほかはガーター"
              (should= 28 (game-score [10 4 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))

          (it "1フレームがスペア、2フレーム目がオープン、ほかはガーター"
              (should= 20 (game-score [5 5 3 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))

          (it "10フレーム目だけストライク"
              (should= 17 (game-score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10 3 4])))

          (it "10フレーム目だけスペア"
              (should= 16 (game-score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7 3 6]))))
