;; (+ 40 2)
(require '[clojure.string :as str])

;;Read lines
(str/split (slurp "sample_tweets.txt") #"\W")
