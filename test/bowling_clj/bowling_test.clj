(ns bowling-clj.bowling-test
  (:require [clojure.test :refer :all]
            [bowling-clj.bowling :refer :all]))

(deftest a-test
  (testing "Gutter balls"
    (def the-score (score-game [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))
    (is (= 0 the-score)))

  (testing "All ones"
    (def the-score (score-game [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]))
    (is (= 20 the-score)))

  (testing "Spare"
    (def the-score (score-game [2 8 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))
    (is (= 20 the-score)))

  (testing "Strike"
    (def the-score (score-game [10 3 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))
    (is (= 24 the-score)))

  (testing "All spares"
    (def the-score (score-game [5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5]))
    (is (= 150 the-score)))

  (testing "All strikes"
    (def the-score (score-game [10 10 10 10 10 10 10 10 10 10 10 10]))
    (is (= 300 the-score)))

  )
