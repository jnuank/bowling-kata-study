(ns clojure-data-transform.core
  (:gen-class))

(defn frames [rolls]
  [[0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0] [0 0]])

(defn score [rolls]
  (reduce + rolls))