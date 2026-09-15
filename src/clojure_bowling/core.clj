(ns clojure-bowling.core
  (:gen-class))

(defn score [throws]
  (if (empty? throws)
    0
    (let [first-roll (first throws)
          second-roll (second throws)
          strike? (= 10 first-roll)
          spare? (= 10 (+ first-roll second-roll))]
      (cond
        strike?
        (+ 10 (nth throws 1) (nth throws 2) (score (drop 1 throws)))

        spare?
        (+ 10 (nth throws 2) (score (drop 2 throws)))
        
        :else
        (+ first-roll  second-roll
           (score (drop 2 throws)))))))
