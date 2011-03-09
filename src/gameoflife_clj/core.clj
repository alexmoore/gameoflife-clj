(ns gameoflife-clj.core)

(defn overpopulated? [live_neighbors]
  (> live_neighbors 3))

(defn underpopulated? [live_neighbors]
  (< live_neighbors 2))

(defn perfect_population? [live_neighbors]
  (or (= live_neighbors 2)
      (= live_neighbors 3)))

(defn new_status [current_status live_neighbors]
  (cond
    (or (underpopulated? live_neighbors)
        (overpopulated? live_neighbors)) :dead
    (perfect_population? live_neighbors) :live))
