(ns gameoflife-clj.core)

(defstruct world :width :height :cells)
(defstruct cell :x :y :state)

(defn underpopulated? [live-neighbors]
  (< live-neighbors 2))

(defn overpopulated? [live-neighbors]
  (> live-neighbors 3))

(defn perfect-population? [live-neighbors]
  (or (= live-neighbors 2)
      (= live-neighbors 3)))

(defn new-status [current-status live-neighbors]
  (cond
    (and (= 3 live-neighbors)
         (= current-status :dead)) :live
    (and (perfect-population? live-neighbors)
         (= current-status :live)) :live
    :else :dead))

(defn create-world [width height]
  (replicate height (replicate width :dead)))
