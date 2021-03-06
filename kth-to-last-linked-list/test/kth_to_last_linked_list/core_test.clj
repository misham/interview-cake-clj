(ns kth-to-last-linked-list.core-test
  (:require [clojure.test :refer :all]
            [kth-to-last-linked-list.core :refer :all]
            [kth-to-last-linked-list.list :as list]))

(def list-a (list/coll->list [4 2 5]))
(def list-b (list/coll->list [6 7 8]))
(def list-c (list/coll->list [5 8 3 4 5 8]))
(def list-d (list/coll->list [3 56 99 72 45 76 1 29]))
(def list-e (list/coll->list (range 0 50 3)))

(def edge-a (list/coll->list []))
(def edge-b (list/coll->list [7]))

(deftest kth-to-last-node-test
  (testing "edge cases"
    (is (= (kth-to-last-node edge-a 0) nil))
    (is (= (kth-to-last-node edge-b 0) 7))
    (is (= (kth-to-last-node edge-b 5) nil))
    (is (= (kth-to-last-node list-b 2) 6)))
  (testing "returns kth from last node in list"
    (is (= (kth-to-last-node list-a 0) 5))
    (is (= (kth-to-last-node list-a 1) 2))
    (is (= (kth-to-last-node list-b 2) 6))
    (is (= (kth-to-last-node list-c 3) 3))
    (is (= (kth-to-last-node list-d 4) 72))
    (is (= (kth-to-last-node list-d (dec (list/length list-d))) 3))
    (is (= (kth-to-last-node list-e 5) 33))))
