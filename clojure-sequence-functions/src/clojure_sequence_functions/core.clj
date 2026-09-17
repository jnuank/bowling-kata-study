(ns clojure-sequence-functions.core
  (:gen-class))

(defn- two-roll-sum [pins]
  (reduce + (take 2 pins)))

(defn- score* [pins frame]
  (cond
    (empty? pins)
    0

    (= 10 frame)
    (reduce + pins)

    :else
    (let [spare? (= 10 (two-roll-sum pins))
          strike? (= 10 (first pins))
          next-frame (inc frame)]
      (cond
        strike? (+ 10 (two-roll-sum (drop 1 pins)) (score* (drop 1 pins) next-frame))
        spare? (+ 10 (first (drop 2 pins)) (score* (drop 2 pins) next-frame))
        :else (+ (two-roll-sum pins) (score* (drop 2 pins) next-frame))))))

(defn score [pins]
  (score* pins 1))
