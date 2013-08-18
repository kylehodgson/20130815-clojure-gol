(ns gol.core
  (:gen-class))

(defn count-live-cells [cells]
	(reduce + (flatten cells)))

(defn get-central-cells-state [neighborhood]
	(* (nth (flatten neighborhood) 4) 1))

(defn count-live-neighbors [neighborhood]
	 (- 
	 	(count-live-cells neighborhood)
	 	(get-central-cells-state neighborhood)))

(defn extract-neighborhood [board x y]
	(concat 
		[(get (board (- y 1) ) (- x 1) 0)
	     (get (board (- y 1) )    x    0)
	     (get (board (- y 1) ) (+ x 1) 0)]
	    [(get (board    y    ) (- x 1) 0)
	     (get (board    y    )    x    0)
	     (get (board    y    ) (+ x 1) 0)]
	    [(get (board (+ y 1) ) (- x 1) 0)
	     (get (board (+ y 1) )    x    0)
	     (get (board (+ y 1) ) (+ x 1) 0)] ))

(defn live-neighbors [board x y]
	(count-live-neighbors
		(extract-neighborhood board x y)))