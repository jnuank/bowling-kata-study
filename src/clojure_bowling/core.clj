(ns clojure-bowling.core
  (:gen-class))

(defn score [throws]
  (if (empty? throws)
    0
    (let [first-roll (first throws)
          second-roll (second throws)]
      (if (= (+ first-roll second-roll) 10)
        (+ 10 (nth throws 2)
           (score (drop 2 throws)))
        (+ first-roll second-roll
           (score (drop 2 throws)))))))
