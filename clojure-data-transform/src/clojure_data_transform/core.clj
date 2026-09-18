(ns clojure-data-transform.core
  (:gen-class))

(defn- per-frame-roll [[a b & rest :as rolls]]
  (cond
    (empty? rolls) []
    (= 10 a) (cons [a] (per-frame-roll (cons b rest)))
    :else (cons [a b] (per-frame-roll rest))))

(defn per-frame-rolls [rolls]
  (per-frame-roll rolls))

(defn frame-scores [frames]
  (map (partial apply +) frames))

(defn game-score [rolls]
  (->> rolls
       per-frame-rolls
       frame-scores
       (reduce +)))

(per-frame-roll [0 0 1 2 3 4])