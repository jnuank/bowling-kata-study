(ns clojure-bowling.core-test
  (:require [clojure.test :refer :all]
            [clojure-bowling.core :refer [score]]))

; TODO: bowring 
; gutter 0
; 10回投げて すべて 0  の場合は 0 を返す
; 特別なものはなし
; 10回投げて すべて1 の場合は 20 を返す

(deftest score-test
  (testing "score should be 0 for gutter game"
    (is (= (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]) 0))))


; スペア
; 1回投げてスペア。2回目はガーター。その後0なら10を返す



; ストライク
; 1回投げてストライク。2回目はガーター。その後0なら10を返す
; 1回投げてストライク。2回目は9。その後0なら19を返す
; 1回投げてストライク。2回目はスペア。その後0なら20を返す