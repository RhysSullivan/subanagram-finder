(ns subanagram-finder.core
  "Clojure Sub-anagram Finder. Usage:
    lein run -- word [word ...]

   Champlain College
   CSI-380 Spring 2019"
  (:gen-class))

(require '[clojure.string :as str])


(defn load-dictionary 
  "Load list of words from disk."
  ([] (load-dictionary "resources/words"))
  ([file-name]
     (str/split-lines (slurp file-name))
  ))
  

(defn find-sub-anagrams 
  "Find all the words in word-list that are sub-anagrams of word.

  A sub-anagram means it is an anagram of a substring of word."
  [word, word-list]
  ;; Code goes here

  (let [letter_counts (frequencies (clojure.string/lower-case word))]
  
  (defn is_sub_anagram[other_word]
    (
      if (< (count word) (count other_word)) ;; TODO: Maybe not?
        false  ;; True so return false
          (let [other_letter_counts (frequencies (clojure.string/lower-case other_word))]
            (every? identity (map #(>= (letter_counts % 0) (other_letter_counts %)) (keys other_letter_counts) ) )
            
          )
    )
  )
  )
  (filter is_sub_anagram word-list)
)    

(defn generate-output 
  "Generate the output.

   For each word the output contains a line with all the sub-anagrams of that 
   word (in sorted order) separated by spaces.
   Example: (generate-output [\"tea\", \"ok\"]) -> 
            \"A At E T Ta a at ate e eat eta t tea\nK O OK k o\"
  "
  [words]
  (let [dictionary (load-dictionary)]
      (let [all_anagrams ( map #(find-sub-anagrams % dictionary) words)]
        (clojure.string/join "\n" (map #(clojure.string/join " " %)  all_anagrams) )
      )
    )
  )
  

(defn -main 
  "Main function, generates the output and prints it to the console."
  [& args]
  (if (= 0 (count args))
    ;; then
    (println "Usage:\n\tlein run -- word [word ...]")
    ;; else
    (println (generate-output args))))    
