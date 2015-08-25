;; (+ 40 2)
(require '[clojure.string :as str])

;;Read lines
(partition 2 1 (filter #(not (str/blank? %)) (str/split (slurp "sample_tweets.txt") #"\W")))
