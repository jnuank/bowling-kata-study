(ns clojure-defmulti.core
  (:gen-class))

(defn score [rolls]
  (reduce + rolls))