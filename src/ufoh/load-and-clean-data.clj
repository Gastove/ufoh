(ns ufoh.load-and-clean
  (:require [incanter.core :as core :refer [$ $map conj-cols col-names]]
            [incanter.io :as io :refer [read-dataset]]
            ))

(defn load-clean [path]
  (let [data (read-dataset path :delim \tab)
        columns (col-names data)
        good-cols (take 5 columns)
        bad-cols (drop 5 columns)
        cleanup (fn [& args] (apply str args))]
    (->> ($map cleanup bad-cols data)
         (conj-cols ($ good-cols data)))))

(defn get-data []
  (let [data (load-clean "./lib/ufo_awesome.tsv")
        headers [:sighted_at :reported_at :location :shape :duration :description]]
    (col-names data headers)
    ))
