(ns funcional-progam-jconfpe-2020.core
  (:gen-class))

;Intro clojure
(defn add
  [x y]
  (+ x y))

(+ 3 4)

(def add* (fn [x y] (+ x y)))

(def add** #(+ %1 %2))

(defn nil*
  [x y]
  (+ x y)
  nil)

(defn hello-world
  [name]
  (println (str "Hello world! " name)))

;Funciones puras
(def y 4)

(defn add
  [x]
  (+ x y))

(add 3)

(defn add
  [x]
  (+ x (rand-int 8)))

(defn add
  [x y]
  (println (+ x y)))

(add 3 4)

(defn add
  [x y]
  (+ x y))

(add 3 4)
(add 4 4)
(add 6 4)

; Funciones de primera clase y de orden superior
(def add (fn [x y] (+ x y)))

(add 3 4)
(add 1 7)

(defn execute
  [op x y]
  (op x y))

(execute + 3 4)
(execute - 3 4)
(execute * 3 4)

(defn add
  [x]
  (fn [y] (+ x y)))

(def partial-add (add 3))

(partial-add 4)
(partial-add 5)

;Inmutabilidad

(def customer {:category "Premium"})
(def weight-customer (assoc customer :weight 68.8))

(println customer)
(println weight-customer)

(def plus-weight-customer (update weight-customer :weight inc))

(println weight-customer)
(println plus-weight-customer)

; Recursion
(defn sum
  [nums]
  (if (empty? nums)
    0
    (+ (first nums)
      (sum (rest nums)))))

(defn sum
  [nums]
  (loop [values nums
         acc 0]
    (if (empty? values)
      acc
      (recur (rest values) (+ acc (first values))))))

(sum [1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9])
(sum (take 100000 (repeat 1)))

(reduce + 0 (take 100000 (repeat 1)))
