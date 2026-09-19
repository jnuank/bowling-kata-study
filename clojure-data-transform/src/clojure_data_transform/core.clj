(ns clojure-data-transform.core
  (:gen-class))

(defn scoring-rolls-per-frame* [[first-roll second-roll bonus-roll :as rolls] frame-count]
  (let [next-frame (inc frame-count)
        strike? (= 10 first-roll)
        spare? (and second-roll (= 10 (+ first-roll second-roll)))
        game-set? (or (empty? rolls) (> frame-count 10))]
   (cond
    game-set? []
    strike? (cons [first-roll second-roll bonus-roll] (scoring-rolls-per-frame* (rest rolls) next-frame))
    spare? (cons [first-roll second-roll bonus-roll] (scoring-rolls-per-frame* (drop 2 rolls) next-frame))
    :else (cons [first-roll second-roll] (scoring-rolls-per-frame* (drop 2 rolls) next-frame)))))

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
