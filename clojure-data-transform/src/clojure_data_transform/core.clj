(ns clojure-data-transform.core
  (:gen-class))

(defn- frame? [rolls]
  (let [first-roll (first rolls)
        second-roll (second rolls) ]
    (cond
      (= 10 first-roll) :strike
      (= 10 (and second-roll (+ first-roll second-roll))) :spare
      :else :open)))

(defn scoring-rolls-per-frame* [[first-roll second-roll bonus-roll :as rolls] frame-count]
  (let [next-frame (inc frame-count)
        game-set? (or (empty? rolls) (> frame-count 10))]
    (if game-set?
      []
    (case (frame? rolls)
      :strike (cons [first-roll second-roll bonus-roll] (scoring-rolls-per-frame* (rest rolls) next-frame))
      :spare (cons [first-roll second-roll bonus-roll] (scoring-rolls-per-frame* (drop 2 rolls) next-frame))
      :open (cons [first-roll second-roll] (scoring-rolls-per-frame* (drop 2 rolls) next-frame))))))


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
