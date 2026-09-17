(ns clojure-sequence-functions.core
  (:gen-class))

(defn- two-roll-sum [pins]
  (reduce + (take 2 pins)))

(defn- frame-kind [pins]
  (cond
    (= 10 (first pins)) :strike
    (= 10 (two-roll-sum pins)) :spare
    :else :open))

(defn- score* [pins frame]
  (cond
    (empty? pins)    0

    (= 10 frame)    (reduce + pins)

    :else
    (cond
      (= :strike (frame-kind pins)) (+ 10 (two-roll-sum (drop 1 pins)) (score* (drop 1 pins) (inc frame)))
      (= :spare (frame-kind pins)) (+ 10 (first (drop 2 pins)) (score* (drop 2 pins) (inc frame)))
      (= :open (frame-kind pins)) (+ (two-roll-sum pins) (score* (drop 2 pins) (inc frame))))))

(defn score [pins]
  (score* pins 1))
