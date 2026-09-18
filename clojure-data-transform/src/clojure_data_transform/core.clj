(ns clojure-data-transform.core
  (:gen-class))

(defn per-frame-rolls [rolls]
  (partition 2 rolls))

(defn frame-scores [frames]
  (map (partial apply +) frames))

(defn game-score [rolls]
  (->> rolls
       per-frame-rolls
       frame-scores
       (reduce +)))

(game-score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])
