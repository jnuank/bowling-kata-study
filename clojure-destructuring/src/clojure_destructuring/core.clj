(ns clojure-destructuring.core
  (:gen-class))

(defn score [pins]
  (let [[a b & pins] pins]
    (if (= 10 (+ a b))
      (+ 10 a (+ b (first pins)) (score pins))
      (+ a b (score pins))))) 