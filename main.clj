;; (+ 40 2)
(require '[clojure.string :as str])

;; Tip - refactor assoc into update-in

;;Read lines
(def db (reduce (fn [database pair] (assoc database (first pair) (cons (second pair) (get database (first pair)))))
  {}
  (partition 2 1
           (filter #(not (str/blank? %))
                   (str/split ( slurp "sample_tweets.txt") #"\s")))))

;; Prints var
(def word (rand-nth (keys db)))

(repeatedly 10
            #(print word (rand-nth (db word)) ""))

