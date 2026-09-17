(ns clojure-destructuring.core
  (:gen-class))

(defn score [pins]
  (reduce + pins))