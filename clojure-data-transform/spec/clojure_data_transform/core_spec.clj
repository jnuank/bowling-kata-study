(ns clojure-data-transform.core-spec
  (:require [clojure-data-transform.core :refer [game-score
                                                 ]]
            [speclj.core :refer [describe it should=]]))

(describe "game-score"
          (it "全部ガーター"
              (should= 0 (game-score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))
          
          ;; (it "全部ストライク"
          ;;     (should= 300 (game-score [10 10 10 10 10 10 10 10 10 10 10 10])))
          ;; 
          ;; (it "全部スペア"
          ;;     (should= 150 (game-score [5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5])))
          ;; 
          )

