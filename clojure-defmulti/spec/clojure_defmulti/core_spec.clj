(ns clojure-defmulti.core-spec
  (:require [clojure-defmulti.core :refer [score]]
            [speclj.core :refer [describe it should=]]))

(describe "score"

          (it "全ガーター"
              (should= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))
