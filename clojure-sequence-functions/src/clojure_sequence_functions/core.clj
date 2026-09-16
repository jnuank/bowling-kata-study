(ns clojure-sequence-functions.core
  (:gen-class))

(defn score [pins]
  (reduce + pins))