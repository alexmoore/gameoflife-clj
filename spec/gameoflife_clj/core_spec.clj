(ns gameoflife-clj.test.core
  (:use [gameoflife-clj.core] :reload)
  (:use [speclj.core]))

(describe "A live cell"

  (it "should die with fewer than 2 live neighbors"
    (should= :dead (new_status :live 0))
    (should= :dead (new_status :live 1)))
  
  (it "should stay live with 2 or 3 live neighbors"
    (should= :live (new_status :live 2))
    (should= :live (new_status :live 3)))
          
  (it "should die with more than 3 live neighbors"
    (should= :dead (new_status :live 4))))

(describe "A dead cell"

  (it "should resurect with exactly 3 live neighbors"
    (should= :live (new_status :dead 3))))

(describe "Overpopulation"

  (it "should occur when a cell has more than 3 live neighbors"
    (should (overpopulated? 4))
    (should-not (overpopulated? 2))))

(describe "Underpopulation"

  (it "should occur when a cell has less than 2 live neighbors"
    (should (underpopulated? 0))
    (should-not (underpopulated? 3))))

(describe "Perfect Population"

  (it "should occur when a cell has exactly 2 or 3 live nieghbors"
    (should (perfect_population? 2))
    (should (perfect_population? 3))))
