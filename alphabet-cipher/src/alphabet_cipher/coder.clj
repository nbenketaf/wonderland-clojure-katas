(ns alphabet-cipher.coder)

(def nb-chars 26)

(defn idx [c]
  (- (int c) (int \a))) ;; int \a = 97

(defn char-at [i]
  (char (+ i (int \a))))

(defn encode-pair [k m]
  (char-at (mod (+ (idx k) (idx m)) nb-chars))) ;; 26 = nb of letters in the alphabet

(defn decode-pair [k m]
  (char-at (mod (- (idx m) (idx k)) nb-chars)))

(defn pairs [keyword message]
  (map vector (cycle keyword) message))

(defn *code [keyword message f]
  (apply str (map #(apply f %) (pairs keyword message))))

(defn encode [keyword message]
  (*code keyword message encode-pair))

(defn decode [keyword message]
  (*code keyword message decode-pair))
