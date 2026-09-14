(ns clojure-bowling.core
  (:gen-class))

(defn score [throws]
  (if (empty? throws)
    0
    (let [a (first throws)
          b (second throws)]
      (if (= (+ a b) 10)
        (+ 10 (nth throws 2)
           (score (drop 2 throws)))
        (+ a b
           (score (drop 2 throws)))))))
