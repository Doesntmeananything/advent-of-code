(ns day1
  (:require [clojure.string :refer [split-lines]]
            [clojure.test :refer [deftest is testing]]))

(defn read-input
  [path]
  (->> (slurp path)
       (split-lines)
       (map read-string)))

(def input "2020/day1/input.txt")

;; Part 1

(defn find-pair
  [expense-report sum]
  (reduce
   (fn [nums cur-num]
     (let [req-num (- sum cur-num)]
       (if (contains? nums cur-num)
         (reduced  [cur-num req-num])
         (conj nums req-num))))
   #{}
   expense-report))

(prn (apply * (find-pair (read-input input) 2020)))

;; Part 2

(defn drop-nth
  [n coll]
  (keep-indexed #(when (not= %1 n) %2) coll))

(defn find-triplet
  [expense-report sum]
  (loop [n 0]
    (let [item (nth expense-report n)
          filtered-list (drop-nth n expense-report)
          pair (find-pair filtered-list (- sum item))]
      (if (not= 2 (count pair))
        (recur (inc n))
        (conj pair item)))))

(prn (apply * (find-triplet (read-input input) 2020)))

(def test-expense-report
  [1721
   979
   366
   299
   675
   1456])

(deftest fix-expense-report
  (testing "find two entries that sum up to 2020"
    (is (= (apply + (find-pair test-expense-report 2020)) 2020)))
  (testing "find three entries that sum up to 2020"
    (is (= (apply + (find-triplet test-expense-report 2020)) 2020))))
