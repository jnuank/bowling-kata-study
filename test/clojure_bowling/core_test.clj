(ns clojure-bowling.core-test
  (:require [clojure.test :refer :all]
            [clojure-bowling.core :refer [score]]))

; TODO: bowring 
; gutter 0
; 10回投げて すべて 0  の場合は 0 を返す
; 特別なものはなし
; 10回投げて すべて1 の場合は 20 を返す

(deftest score-test
  (testing "すべてガーターなら0"
    (is (= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))
  (testing "すべて1なら20"
    (is (= 20 (score [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1])))))

; スペア
; 1回投げてスペア。2回目はガーター。その後0なら10を返す
(deftest score-spare-test
  (testing "1回投げてスペア。2回目はガーター。その後0なら10を返す"
    (is (= 10 (score [5 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))
  (testing "1回投げてスペア。2回目は9。その後0なら28を返す"
    (is (= 28 (score [5 5 9 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))))

; ストライク
; 1回投げてストライク。2回目はガーター。その後0なら10を返す
; 1回投げてストライク。2回目は9。その後0なら19を返す
; 1回投げてストライク。2回目はスペア。その後0なら20を返す

(deftest score-strike-test
  (testing "1回投げてストライク。2回目以降は0なら、10を返す"
    (is (= 10 (score [10 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])))))
