(ns clojure-data-transform.core
  (:gen-class))

(defn frames [rolls]
  (partition 2 rolls)
  )

(defn score [rolls]
  (let [frames (frames rolls)]
    (reduce + (map (fn [frame] (reduce + frame)) frames))))