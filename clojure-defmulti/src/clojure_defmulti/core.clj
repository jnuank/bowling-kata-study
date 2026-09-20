(ns clojure-defmulti.core
  (:gen-class))

(defmulti frame-type
  "フレームのロールからタイプを判定する"
  (fn [rolls]
    (let [first (first rolls)
          second (second rolls)]
      (cond
        (= 3 (count rolls)) :last
        (= first 10) :strike
        (= (+ (or first 0) (or second 0)) 10) :spare
        :else :open))))

(defmethod frame-type :strike [rolls]
  {:score (reduce + (take 3 rolls)) :rest (rest rolls)})

(defmethod frame-type :spare [rolls]
  {:score (+ 10 (nth rolls 2)) :rest (drop 2 rolls)})

(defmethod frame-type :open [rolls]
  {:score (reduce + (take 2 rolls)) :rest (drop 2 rolls)})

(defmethod frame-type :last [rolls]
  {:score (reduce + rolls) :rest []})

(defn frame-score [rolls]
  (if (empty? rolls)
    []
    (let [frame (frame-type rolls)]
      (cons (:score frame) (frame-score (:rest frame))))))

(defn score [rolls]
  (->> rolls
       frame-score
       (reduce +)))


