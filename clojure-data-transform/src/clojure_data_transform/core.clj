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
  (let [first-frame-score (reduce + first-frame)
        strike? (= 10 first-frame-score)
        spare? (= 10 (reduce + first-frame))
        next-roll (take 1 (flatten rest-frames))
        next-two-rolls (take 2 (flatten rest-frames))]
    (cond
      (empty? first-frame) []
      strike? (-> (+ first-frame-score (reduce + next-two-rolls)) (cons (frame-scores* rest-frames)))
      spare? (-> (+ first-frame-score (reduce + next-roll)) (cons (frame-scores* rest-frames)))
      :else (cons first-frame-score (frame-scores* rest-frames)) ))
)
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
