(ns clojure-bowling.core
  (:gen-class))

(defn score [throws]
  (if (empty? throws)
    0
    (let [first-roll (first throws)
          second-roll (second throws)]
      (cond
        (= 10 first-roll)
        (+ 10 (nth throws 1) (nth throws 2) (score (drop 1 throws)))

        (= 10 (+ first-roll second-roll))
        (+ 10 (nth throws 2) (score (drop 2 throws)))
        
        :else
        (+ first-roll  second-roll
           (score (drop 2 throws)))))))
