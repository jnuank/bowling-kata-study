(ns clojure-bowling.core
  (:gen-class))

(defn- frame-kind [throws]
  (let [first-roll (first throws)
        second-roll (second throws)
        strike? (= 10 first-roll)
        spare? (= 10 (+ first-roll second-roll))]
    (cond
      strike? :strike
      spare? :spare
      :else :open)))

(defn- frame-points [throws]
  (case (frame-kind throws)
    :strike (+ 10 (reduce + (take 2 (rest throws))))
    :spare (+ 10 (nth throws 2))
    :open (+ (first throws) (second throws))))

(defn- remaining-throws [throws]
  (case (frame-kind throws)
    :strike (rest throws)
    (drop 2 throws)))

(defn- score* [throws frame]
  (if (== 10 frame)
    (frame-points throws)
    (+ (frame-points throws) (score* (remaining-throws throws) (inc frame)))))

(defn score [throws]
  (if (empty? throws)
    0
    (score* throws 1)))
