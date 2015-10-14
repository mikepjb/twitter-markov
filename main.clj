(require '[clojure.string :as str])

(def db
  (reduce
    (fn [database pair] (update database (first pair) conj (second pair)))
    {}
    (partition 2 1
      (str/split (slurp "sample_tweets.txt") #"\s+"))))

(defn next-word [current-word]
  (cons current-word (if (.endsWith current-word ".") [] (next-word (rand-nth (db current-word))))))

(defn tweetgen [first-word] (str/join " " (next-word first-word)))

(tweetgen "Split")
