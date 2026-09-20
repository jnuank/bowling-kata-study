(ns clojure-defmulti.core
  (:gen-class))

(defn- frame-type [rolls]
    (let [first (first rolls)
          second (second rolls)]
      (cond
        (= 3 (count rolls)) :last
        (= first 10) :strike
        (= (+ (or first 0) (or second 0)) 10) :spare
        :else :open)))

(defmulti frame-points (fn [type rolls] type))
(defmethod frame-points :strike [_ rolls] (reduce + (take 3 rolls)))
(defmethod frame-points :spare [_ rolls] (+ 10 (nth rolls 2)))
(defmethod frame-points :open [_ rolls] (reduce + (take 2 rolls)))
(defmethod frame-points :last [_ rolls] (reduce + rolls))

(defmulti remaining-rolls (fn [type rolls] type))
(defmethod remaining-rolls :strike [_ rolls] (rest rolls))
(defmethod remaining-rolls :spare [_ rolls] (drop 2 rolls))
(defmethod remaining-rolls :open [_ rolls] (drop 2 rolls))
(defmethod remaining-rolls :last [_ _] [])

(defn frame-score [rolls]
  (if (empty? rolls)
    []
    (let [type (frame-type rolls)]
      (cons (frame-points type rolls) (frame-score (remaining-rolls type rolls))))))

(defn score [rolls]
  (->> rolls
       frame-score
       (reduce +)))


