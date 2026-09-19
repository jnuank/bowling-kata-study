(ns clojure-data-transform.core
  (:gen-class))

(defn scoring-rolls-per-frame [rolls]
  (partition 2 rolls)
  )

(defn game-score [rolls]
  0)


