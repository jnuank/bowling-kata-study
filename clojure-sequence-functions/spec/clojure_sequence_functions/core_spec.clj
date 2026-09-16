(ns clojure-sequence-functions.core-spec
  (:require [speclj.core :refer [describe it should=]]
            [clojure-sequence-functions.core :refer [score]]))

(describe "score"
          (it "全フレーム9ピン"
              (should= 90  (score [9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0])))

          (it "1フレーム目スペア、2フレーム目が5と0。その後は0"
              (should= 20  (score [5 5 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))

          (it "全フレームスペア"
              (should= 150 (score [5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5])))
          
          (it "1フレーム目ストライク、2フレーム目が5と4。その後は0"
              (should= 28  (score [10 5 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))
          
          (it "全フレームストライク"
              (should= 300 (score [10 10 10 10 10 10 10 10 10 10 10 10])))
          
          (it "全部ガーター"
              (should= 0   (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))
          
          (it "2フレーム以降がスペアになってもちゃんと計算される"
              (should= 39 (score [5 5 8 1 9 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0]))))
