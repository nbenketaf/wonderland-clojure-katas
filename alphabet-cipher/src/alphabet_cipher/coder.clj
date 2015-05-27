(ns alphabet-cipher.coder)

(defn idx [c]
  (- (int c) 97)) ;; int \a = 97

(defn char-at [i]
  (char (+ i 97)))

(defn encode-pair [k m]
  (char (+ (mod (+ (idx k) (idx m)) 26) 97))) ;; 26 = nb of letters in the alphabet

(defn decode-pair [k m]
  (char (+ (mod (- (idx m) (idx k)) 26) 97)))

(defn pairs [keyword message]
  (map vector (cycle keyword) message))

(defn encode [keyword message]
  (apply str (map #(apply encode-pair %) (pairs keyword message))))

(defn decode [keyword message]
  (apply str (map #(apply decode-pair %) (pairs keyword message))))
