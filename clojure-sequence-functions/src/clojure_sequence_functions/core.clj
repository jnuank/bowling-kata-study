(ns clojure-sequence-functions.core
  (:gen-class))


(defn- score* [pins frame]
  (if (empty? pins)
    0
    (let [spare? (= 10 (reduce + (take 2 pins)))
          strike? (= 10 (first pins))
          ten-frame? (= 10 frame)
          next-frame (inc frame)]
      (if ten-frame?
        (reduce + pins)
        (cond
          strike? (+ 10 (reduce + (take 2 (drop 1 pins))) (score* (drop 1 pins) next-frame))
          spare? (+ 10 (first (drop 2 pins)) (score* (drop 2 pins) next-frame))
          :else (+ (reduce + (take 2 pins)) (score* (drop 2 pins) next-frame)))))))

(defn score [pins]
  (score* pins 1))
