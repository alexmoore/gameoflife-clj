(ns gameoflife-clj.core)

(defstruct world :width :height :cells)
(defstruct cell :x :y :state)

(defn overpopulated? [live-neighbors]
  (> live-neighbors 3))

(defn underpopulated? [live-neighbors]
  (< live-neighbors 2))

(defn perfect-population? [live-neighbors]
  (or (= live-neighbors 2)
      (= live-neighbors 3)))

(defn new-status [current-status live-neighbors]
  (cond
    (or (underpopulated? live-neighbors)
        (overpopulated? live-neighbors)) :dead
    (perfect-population? live-neighbors) :live))

(defn create-world [width height]
  (replicate height (replicate width :dead)))
