(ns clojure-destructuring.core
  (:gen-class))

(defn- score* [pins frame]
  (let [[a b & [next-pin :as remaining-pins] :as pins] pins]
    (cond
      (empty? pins)
      0
      
      (= frame 10)
      (reduce + pins)

      (= 10 a)
      (+ 10 b next-pin (score* (concat [b] remaining-pins) (inc frame)))

      (= 10 (+ a b))
      (+ 10 (first remaining-pins) (score* remaining-pins (inc frame)))

      :else
      (+ a b (score* remaining-pins (inc frame))))))

(defn score [pins]
  (score* pins 1))

