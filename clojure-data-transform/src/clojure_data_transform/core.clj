(ns clojure-data-transform.core
  (:gen-class))

(defn frames [rolls]
  (partition 2 rolls))

(defn scores [frames]
  (map (partial apply +) frames))

(defn score [rolls]
  (->> rolls
       frames
       scores
       (reduce +)))

(score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])
