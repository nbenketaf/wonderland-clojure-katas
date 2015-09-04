(ns wonderland-number.finder)

(defn same-digits? [n m]
  (= (set (str n)) (set (str m))))

(defn is-wonderland-number [n]
  (every? #(same-digits? n (* n %)) (range 2 7)))

(defn wonderland-number []
  (->> (range 100000 1000000)
       (filter #(is-wonderland-number %))
       first))
