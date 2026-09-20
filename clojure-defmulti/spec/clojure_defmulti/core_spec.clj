(ns clojure-defmulti.core-spec
  (:require [clojure-defmulti.core :refer [score frame-points]]
            [speclj.core :refer [describe it should=]]))

(describe "score"
          (it "全ガーター"
              (should= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))
          
          (it "1フレーム目が4と5。その後はガーター"
              (should= 9 (score [4 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))
          
          (it "1フレーム目がスペア。2フレーム目が4と5。その後はガーター"
              (should= 23 (score [4 6 4 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))

          (it "1フレーム目がストライク。2フレーム目が4と5。その後はガーター"
              (should= 28 (score [10 4 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))

          (it "全フレームスペア"
              (should= 150 (score [5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5])))
          
          (it "全フレームストライク"
              (should= 300 (score [10 10 10 10 10 10 10 10 10 10 10 10]))))