(ns clojure-data-transform.core
  (:gen-class))

(defn frames [rolls]
  (partition 2 rolls)
  )

(defn score [rolls]
  (->> rolls
       frames
       (map (partial apply +))
       (reduce +)
       )
  )

(score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0])
