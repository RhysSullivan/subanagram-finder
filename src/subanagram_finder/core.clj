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
  (println "=================================")
  (println "=================================")
  (println "=================================")
  (println "=================================")
  (def word_length (count word))
  (def letter_counts (frequencies (clojure.string/lower-case word)))
  
  (defn is_sub_anagram[other_word]
    (def other_word_length (count other_word))
    (
      if (< word_length other_word_length) ;; TODO: Maybe not?
        false  ;; True so return false
        (
          (def other_letter_counts (frequencies (clojure.string/lower-case other_word)))
          (def other_letter_keys (keys other_letter_counts))
          (map
            (fn [letter] (
              (
                >=
                (get letter_counts letter 0)
                (get other_letter_counts letter)
              )
            )
            )
            other_letter_keys
          )
          

          true
        ) 
    )
  )
  
  (println(filter is_sub_anagram word-list))
  (println "=================================")
  (println "=================================")
  (println "=================================")
  (println "=================================")
  (println "=================================")
  (println "=================================")
)  

(defn generate-output 
  "Generate the output.

   For each word the output contains a line with all the sub-anagrams of that 
   word (in sorted order) separated by spaces.
   Example: (generate-output [\"tea\", \"ok\"]) -> 
            \"A At E T Ta a at ate e eat eta t tea\nK O OK k o\"
  "
  [words]
  ;; Code goes here
  )
  

(defn -main 
  "Main function, generates the output and prints it to the console."
  [& args]
  (if (= 0 (count args))
    ;; then
    (println "Usage:\n\tlein run -- word [word ...]")
    ;; else
    (println (generate-output args))))    
