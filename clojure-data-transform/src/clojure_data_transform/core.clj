(ns clojure-data-transform.core
  (:gen-class))

; そもそも計算モデルに合わない
(defn- per-frame-rolls* [[a b & rest :as rolls]]
  (cond
    (empty? rolls) []
    (= 3 (count rolls)) [rolls]
    (= 10 a) (cons [a] (per-frame-rolls* (cons b rest)))
    :else (cons [a b] (per-frame-rolls* rest))))

(defn- ->frame [rolls]
  (cond
    (= 10 (first rolls)) {:type :strike :rolls rolls}))

(defn per-frame-rolls [rolls]
  (per-frame-rolls* rolls))

; {:type :open :rolls [1 2]}
(defn- frame-score** [[first-frame & rest-frames]]
  (cond))

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
      :else (cons first-frame-score (frame-scores* rest-frames)))))

(defn frame-scores [frames]
  (frame-scores* frames))

(defn- one-frame-score [[first-frame second-frame third-frame]]
  [let type (:type first-frame)]
    (case type
      :strike
      (reduce + (:rolls first-frame) (cond 
                                       (= :strike (:type second-frame)) 
                                       (reduce + (:rolls second-frame) (reduce + (:rolls third-frame)))))
      :open
      (reduce + (:rolls first-frame) (reduce + (:rolls second-frame)))
      nil
      []))

(defn frame-scores** [[first-frame & rest-frames]]
  (let [type (:type first-frame)]
    (println type)
    (case type
      :strike
      (cons (reduce + (:rolls first-frame) (reduce + )) (frame-scores** rest-frames))
      
      :open
      (cons (reduce + (:rolls firwst-frame)) (frame-scores** rest-frames))
      
      nil
      [])))

(defn- debug [label x]
  (println label (pr-str x))
  x)

(defn game-score [rolls]
  (->> rolls ; [10 1 2 3 4 5 6 7 8 9 10]
       per-frame-rolls ; [{:type :strike :rolls [10]} {:type :open :rolls [1 2]} ...]
       frame-scores ; [13 3 4 5 6 7 8 9 10]
       (reduce +)))
