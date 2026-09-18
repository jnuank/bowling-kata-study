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

(defn frame-scores [frames]
  (map (partial apply +) frames))

(defn game-score [rolls]
  (->> rolls
       per-frame-rolls
       frame-scores
       (reduce +)))

(per-frame-rolls* [0 0 1 2 3 4])