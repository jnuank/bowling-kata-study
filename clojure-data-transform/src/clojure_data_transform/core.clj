(ns clojure-data-transform.core
  (:gen-class))

(defn- per-frame-rolls* [[a b & rest :as rolls]]
  (cond
    (empty? rolls) []
    (= 3 (count rolls)) [rolls]
    (= 10 a) (cons [a] (per-frame-rolls* (cons b rest)))
    :else (cons [a b] (per-frame-rolls* rest))))

(defn per-frame-rolls [rolls]
  (per-frame-rolls* rolls))

(defn- frame-scores* [[first-frame & rest-frames]]
  (cond
    (empty? first-frame) []
    (= 10 (reduce + first-frame)) (-> (+ (reduce + first-frame) (reduce + (take 2 (flatten rest-frames)))) (cons (frame-scores* rest-frames)))
    :else (cons (reduce + first-frame) (frame-scores* rest-frames)) ))

(defn frame-scores [frames]
  (frame-scores* frames))

(defn- debug [label x]
  (println label (pr-str x))
  x)

(defn game-score [rolls]
  (->> rolls
       per-frame-rolls
       frame-scores
       (debug "frame-scores")
       (reduce +)))

(per-frame-rolls* [0 0 1 2 3 4])
(flatten [[0 0] [2 3] [10] [4 6]])
(reduce + 2 [1 2 3 4])
(cons 1 [])
(cons 3 '(2))
(cons 1 '(2 3 4))

