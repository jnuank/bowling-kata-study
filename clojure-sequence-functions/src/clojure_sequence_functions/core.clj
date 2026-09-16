(ns clojure-sequence-functions.core
  (:gen-class))

(defn score [pins]
  (let [spare? (= 10 (reduce + (take 2 pins)))
        ]
  (if spare?
    (+ 10 (first (drop 2 pins)) (score (drop 2 pins)))
    (reduce + pins))))