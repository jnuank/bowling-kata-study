(ns clojure-defmulti.core-spec
  (:require [speclj.core :refer [describe it should=]]
            [clojure-defmulti.core :refer [score]]))

(describe "score"
          (it "全ガーター"
              (should= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))