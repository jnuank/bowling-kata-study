(ns clojure-destructuring.core
  (:gen-class))

(defn score [pins]
  (let [[a b & remaining-pins :as pins] pins]
    (cond 
      (empty? pins)
      0
      
      (= 10 (+ a b))
      (+ 10 (first remaining-pins) (score remaining-pins))
      
      :else
      (+ a b (score remaining-pins)))))