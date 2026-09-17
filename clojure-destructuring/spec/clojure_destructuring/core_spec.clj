(ns clojure-destructuring.core-spec
  (:require [clojure-destructuring.core :refer [score]]
            [speclj.core :refer [describe, it, should=]]))

(describe "score"
          (it "全フレーム 9pin"
              (should= 90 (score [9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0])))

          (it "1フレームスペア、2フレーム目は4pinと5pinで、あとはガーター"
              (should= 23 (score [5 5 4 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))

          (it "全フレームスペア"
              (should= 150 (score [5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5])))
          
          (it "全ガーター"
              (should= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))
          
          (it "1フレームストライク、2フレーム目は4pinと5pinで、あとはガーター"
              (should= 28 (score [10 4 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))
          
          (it "全フレームストライク"
              (should= 300 (score [10 10 10 10 10 10 10 10 10 10 10 10])))
          )
