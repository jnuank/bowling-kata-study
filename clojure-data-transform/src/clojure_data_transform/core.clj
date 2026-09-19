(ns clojure-data-transform.core
  (:gen-class))

(defn scoring-rolls-per-frame* [[first-roll second-roll bonus-roll :as rolls] frame-count]
  (cond
    (or (empty? rolls) (> frame-count 10)) []
    (= 10 first-roll) (cons [first-roll second-roll bonus-roll] (scoring-rolls-per-frame* (rest rolls) (inc frame-count)))
    (= 10 (+ first-roll second-roll)) (cons [first-roll second-roll bonus-roll] (scoring-rolls-per-frame* (drop 2 rolls) (inc frame-count)))
    :else (cons [first-roll second-roll] (scoring-rolls-per-frame* (drop 2 rolls) (inc frame-count)))))

(defn scoring-rolls-per-frame [rolls]
  (scoring-rolls-per-frame* rolls 1))

(defn- frame-score [frame]
  (reduce + frame))

(defn frame-scores [frames]
  (map frame-score frames))

(defn game-score [rolls]
  (->> rolls
       scoring-rolls-per-frame
       frame-scores
       (reduce +)))
