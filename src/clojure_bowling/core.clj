(ns clojure-bowling.core
  (:gen-class))

(defn- score* [throws frame]
  (if (empty? throws)
    0
    (let [first-roll (first throws)
          second-roll (second throws)
          strike? (= 10 first-roll)
          spare? (= 10 (+ first-roll second-roll))]
      (if (== 10 frame)
        (cond
          strike?
          (+ 10 (reduce + (take 2 (rest throws))))

          spare?
          (+ 10 (nth throws 2))

          :else
          (+ first-roll  second-roll
             (score* (drop 2 throws) (inc frame))))
        
        (cond
        strike?
        (+ 10 (reduce + (take 2 (rest throws))) (score* (rest throws) (inc frame)))

        spare?
        (+ 10 (nth throws 2) (score* (drop 2 throws) (inc frame)))

        :else
        (+ first-roll  second-roll
           (score* (drop 2 throws) (inc frame))))
        ))))

(defn score [throws]
  (score* throws 1))
