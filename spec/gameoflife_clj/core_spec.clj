(ns gameoflife-clj.core
  (:use [gameoflife-clj.core] :reload)
  (:use [speclj.core]))

(describe "A live cell"

  (it "should die with fewer than 2 live neighbors"
    (should= :dead (new-status :live 0))
    (should= :dead (new-status :live 1)))
  
  (it "should stay live with 2 or 3 live neighbors"
    (should= :live (new-status :live 2))
    (should= :live (new-status :live 3)))
          
  (it "should die with more than 3 live neighbors"
    (should= :dead (new-status :live 4))))

(describe "A dead cell"

  (it "should stay dead with less than 3 live neighbors"
    (should= :dead (new-status :dead 0))
    (should= :dead (new-status :dead 1))
    (should= :dead (new-status :dead 2)))

  (it "should resurect with exactly 3 live neighbors"
    (should= :live (new-status :dead 3)))

  (it "should stay dead with more than 3 live neighbors"
    (should= :dead (new-status :dead 4))))

(describe "Overpopulation"

  (it "should occur when a cell has more than 3 live neighbors"
    (should (overpopulated? 4))
    (should-not (overpopulated? 3))
    (should-not (overpopulated? 2))))

(describe "Underpopulation"

  (it "should occur when a cell has less than 2 live neighbors"
    (should (underpopulated? 1))
    (should-not (underpopulated? 2))
    (should-not (underpopulated? 3))))

(describe "Perfect Population"

  (it "should occur when a cell has exactly 2 or 3 live nieghbors"
    (should (perfect-population? 2))
    (should (perfect-population? 3))))

(describe "A World"

  (it "should be created with a defined width and height and all :dead cells"
    (should= '((:dead :dead :dead) (:dead :dead :dead) (:dead :dead :dead)) (create-world 3 3))))
