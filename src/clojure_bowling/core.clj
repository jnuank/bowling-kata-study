(ns clojure-bowling.core
  (:gen-class))

(defn score [throws]
  (reduce + throws))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Ho, Wd!"))



