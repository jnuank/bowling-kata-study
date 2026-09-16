(ns clojure-sequence-functions.core
  (:gen-class))

(defn score [pins]
  (if (every? #(= % 5) pins)
    150
    (reduce + pins)))