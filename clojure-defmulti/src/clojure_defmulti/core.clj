(ns clojure-defmulti.core
  (:gen-class))

(defn- frame-kind [pins]
  (cond
    (= 10 (first pins)) :strike
    (= 10 (+ (first pins) (second pins))) :spare
    :else :open))

(defmulti frame-score (fn [pins _frame] (frame-kind pins)))

(defmethod frame-score :strike [pins _frame]
  (+ 10 (reduce + (take 2 (rest pins)))))

(defmethod frame-score :spare [pins _frame]
  (+ 10 (nth pins 2)))

(defmethod frame-score :open [pins _frame]
  (+ (first pins) (second pins)))

(defmulti advance (fn [pins _frame] (frame-kind pins)))

(defmethod advance :strike [pins _frame]
  (rest pins))

(defmethod advance :spare [pins _frame]
  (drop 2 pins))

(defmethod advance :open [pins _frame]
  (drop 2 pins))

(defn- score* [pins frame]
  (cond
    (empty? pins) 0
    (= 10 frame) (reduce + pins)
    :else (+ (frame-score pins frame)
             (score* (advance pins frame) (inc frame)))))

(defn score [pins]
  (score* pins 1))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
