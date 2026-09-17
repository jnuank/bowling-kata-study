(ns clojure-data-transform.core
  (:gen-class))

(defn score [rolls]
  (reduce + rolls))