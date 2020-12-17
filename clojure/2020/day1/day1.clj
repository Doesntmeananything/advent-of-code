(ns day1
  (:require [clojure.string :refer [split-lines]]
            [clojure.test :refer [deftest is testing]]))

(defn read-input
  [path]
  (->> (slurp path)
       (split-lines)
       (map read-string)))

(def input-1 "2020/day1/input1.txt")

;; Day 1
;; Part 1

(defn find-sum-entries
  [expense-report]
  (reduce
   (fn [numbers number]
     (let [required-number (- 2020 number)]
       (if (contains? numbers number)
         (reduced  [number required-number])
         (conj numbers required-number))))
   #{}
   expense-report))

(prn (apply * (find-sum-entries (read-input input-1))))


;; Tests
(def test-expense-report
  [1721
   979
   366
   299
   675
   1456])

(deftest fix-expense-report
  (testing "find two entries that sum up to 2020"
    (is (= (apply + (find-sum-entries test-expense-report)) 2020))))
