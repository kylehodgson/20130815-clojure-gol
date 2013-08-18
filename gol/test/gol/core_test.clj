(ns gol.core-test
  (:require [clojure.test :refer :all]
            [gol.core :refer :all]))

(def neighborhood
	[[0 1 0]
	 [1 1 0]
	 [0 1 0]])

(def board
	[[0 1 0 1 0 1]
	 [1 0 1 0 1 0]
	 [0 1 0 1 0 1]
	 [1 0 1 1 0 0]
	 [0 1 0 1 0 1]
	 [1 0 1 0 1 0]])

(deftest can-count-live-cells
	(is (= 
		(count-live-cells neighborhood)
		4)))

(deftest can-count-live-neighbors
	(is (=
		(count-live-neighbors neighborhood)
		3)))

(deftest can-get-central-cells-state
	(is (=
		(get-central-cells-state neighborhood))
		1))

(deftest can-extract-neighborhood-from-board
	(is (=
		(extract-neighborhood board 3 3)
		(flatten neighborhood))))

(deftest can-count-live-neighbors-from-board
	(is (=
		(live-neighbors board 3 3)
		3)))

 ; (deftest can-safely-extract-neighborhood-from-board
 ; 	(is (=
 ; 		(extract-neighborhood board 3 9)
 ; 		(flatten neighborhood))))