(ns clojure-sequence-functions.core
  (:gen-class))

(defn- two-roll-sum [pins]
  (reduce + (take 2 pins)))

(defn- frame-kind [pins]
  (cond
    (= 10 (first pins)) :strike
    (= 10 (two-roll-sum pins)) :spare
    :else :open))

(defn- frame-score [pins kind]
  (case kind
    :strike (+ 10 (two-roll-sum (drop 1 pins)))
    :spare (+ 10 (first (drop 2 pins)))
    :open (two-roll-sum pins)))

(defn- advance [pins kind]
  (case kind
    :strike (drop 1 pins)
    (drop 2 pins)))

(defn- score* [pins frame]
  (cond
    (empty? pins)    0

    (= 10 frame)    (reduce + pins)

    :else
    (+ (frame-score pins (frame-kind pins)) (score* (advance pins (frame-kind pins)) (inc frame)))))

(defn score [pins]
  (score* pins 1))
