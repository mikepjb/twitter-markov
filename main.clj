(require '[clojure.string :as str])

;; Tip - refactor assoc into update-in

(def db (reduce (fn [database pair] (assoc database (first pair) (cons (second pair) (get database (first pair)))))
  {}
  (partition 2 1
           (filter (complement str/blank?)
                   (str/split (slurp "sample_tweets.txt") #"\s")))))

(defn next-word [current-word]
  (if (.endsWith current-word ".") [current-word] (cons current-word (next-word (rand-nth (db current-word)))))
  )

(defn tweetgen [first-word] (str/join " " (next-word first-word)))

(tweetgen "Split")
