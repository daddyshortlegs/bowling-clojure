(ns bowling-clj.bowling
  (:gen-class))

(defn is-spare? [rolls i] (= 10 (+ (nth rolls i) (nth rolls (+ 1 i)))))

(defn score-spare [rolls i] (+ 10 (nth rolls (+ 2 i))))

(defn is-strike? [rolls i] (= 10 (nth rolls i)))

(defn score-strike [rolls i] (+ 10 (nth rolls (+ 1 i)) (nth rolls (+ 2 i))))

(defn score-frame [rolls i] (+ (nth rolls i) (nth rolls (+ 1 i))))

(defn score-rolls [rolls i frame score]
  (if (= frame 10)
    score
    (cond
      (is-spare? rolls i) (score-rolls rolls (+ 2 i) (+ 1 frame) (+ score (score-spare rolls i)))
      (is-strike? rolls i) (score-rolls rolls (+ 1 i) (+ 1 frame) (+ score (score-strike rolls i)))
      (score-rolls rolls (+ 2 i) (+ 1 frame) (+ score (score-frame rolls i)))
      )
    )
  )

(defn score-game [rolls] (score-rolls rolls 0 0 0))
