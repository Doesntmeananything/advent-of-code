(ns day1
  (:require [input]))

;; Part One

(defn fuel-requirement
  [mass]
  (-> mass
      (/ 3)
      (Math/floor)
      (- 2)
      (int)))

(defn sum-of-fuel-requirements
  [mass-vec]
  (->> mass-vec
       (map fuel-requirement)
       (reduce +)))

(sum-of-fuel-requirements input/mass-vec)

;; Part Two

(defn total-fuel-requirement
  [mass]
  (loop [total-fuel 0
         current-mass mass]
    (let [current-requirement (fuel-requirement current-mass)]
      (if (<= current-requirement 0)
        total-fuel
        (recur (+ total-fuel current-requirement)
               current-requirement)))))

(defn sum-of-total-fuel-requirements
  [mass-vec]
  (->> mass-vec
       (map total-fuel-requirement)
       (reduce +)))

(sum-of-total-fuel-requirements input/mass-vec)
