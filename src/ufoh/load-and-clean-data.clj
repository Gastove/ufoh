(ns ufoh.load-and-clean
  (:require [incanter.core :as core :refer [$ $map conj-cols col-names]]
            [incanter.io :as io :refer [read-dataset]]
            ))

(def test-path "./lib/ufo_awesome.tsv")
(def full-path "./lib/test_data.tsv")

(defn load-clean [path]
  (let [data (read-dataset path :delim \tab)
        columns (col-names data)
        good-cols (take 5 columns)
        bad-cols (drop 5 columns)
        cleanup (fn [& args] (apply str args))]
    (->> ($map cleanup bad-cols data)
         (conj-cols ($ good-cols data)))))

(defn get-data [path]
  (let [data (load-clean path)
        headers [:sighted_at :reported_at :location :shape :duration :description]]
    (col-names data headers)
    ))

(defn get-test-dataset (get-data test-path))

(defn get-full-dataset (get-data full-path))
