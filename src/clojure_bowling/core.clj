(ns clojure-bowling.core
  (:gen-class))

(defn score [throws]
  (if (empty? throws)
    0
    (let [first-roll (first throws)
          second-roll (second throws)
          rest-game (drop 2 throws)]
      (if (= 10 (+ first-roll second-roll))
        (+ 10 (nth throws 2)
           (score rest-game))
        (+ first-roll second-roll
           (score rest-game))))))
