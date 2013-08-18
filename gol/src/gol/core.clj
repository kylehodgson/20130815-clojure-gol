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
	(def size (count board))
	(def top-row (dec y))
	(def middle-row y)
	(def bottom-row (inc y))
	(def left-col (dec x))
	(def middle-col x)
	(def right-col (inc x))
	(concat 
		[(nth (board top-row   ) left-col   0)
	     (nth (board top-row   ) middle-col 0)
	     (nth (board top-row   ) right-col  0)]
	    [(nth (board middle-row) left-col   0)
	     (nth (board middle-row) middle-col 0)
	     (nth (board middle-row) right-col  0)]
	    [(nth (board bottom-row) left-col   0)
	     (nth (board bottom-row) middle-col 0)
	     (nth (board bottom-row) right-col  0)] ))

(defn live-neighbors [board x y]
	(count-live-neighbors
		(extract-neighborhood board x y)))