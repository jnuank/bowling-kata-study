(ns clojure-destructuring.core-spec
  (:require [clojure-destructuring.core :refer :all]
            [speclj.core :refer [describe, it, should=]]))

(describe "test"
          (it "test2"
              (should= 2 2)))