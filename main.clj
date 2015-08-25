;; (+ 40 2)
(require '[clojure.string :as str])

;;Read lines
(reduce (fn [database pair] (assoc database (first pair) (cons (second pair) (get database (first pair)))))
  {}
  (partition 2 1
           (filter #(not (str/blank? %))
                   (str/split ( slurp "sample_tweets.txt") #"\W"))))

