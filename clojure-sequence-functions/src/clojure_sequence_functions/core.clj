(ns clojure-sequence-functions.core
  (:gen-class))

(defn- score* [pins frame-count]
  (if (empty? pins)
    0
    (let [spare? (= 10 (reduce + (take 2 pins)))
          strike? (= 10 (first pins))
          ten-frame? (= 10 frame-count)]
      (if ten-frame?
        (reduce + pins)
        (cond
          strike? (+ 10 (reduce + (take 2 (drop 1 pins))) (score* (drop 1 pins) (inc frame-count)))
          spare? (+ 10 (first (drop 2 pins)) (score* (drop 2 pins) (inc frame-count)))
          :else (+ (reduce + (take 2 pins)) (score* (drop 2 pins) (inc frame-count))))))))

(defn score [pins]
  (score* pins 1))
