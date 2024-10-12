package SolvedProblems;

import java.util.*;

public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int sLength = s.length();
        int wordsLength = words.length;
        int wordLength = words[0].length();
        int subStringLength = wordLength * wordsLength;

        if (sLength == 0 || wordsLength == 0) {
            return result;
        }

        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        if (wordFrequency.keySet().size() == 1) {
            StringBuilder sb = new StringBuilder();
            for (String w : words) {
                sb.append(w);
            }

            for (int i = 0; i <= s.length() - subStringLength; i++) {
                if (s.substring(i, i + subStringLength).equals(sb.toString())) {
                    result.add(i);
                }
            }

            return result;
        }

//        shift only by the word length
        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> wordFrequencyCopy = wordFrequency;

//            chop the string in words with wordLength of each and compare to the words map
            for (int j = i; j <= sLength - subStringLength; j += wordLength) {
//                get the sub string based on the total subStringLength
                String currentSubString = s.substring(j, j + subStringLength);
//                reset wordFrequencyCopy
                wordFrequencyCopy = new HashMap<>(wordFrequency);
                int kRecorder = 0;
                boolean matched = true;
//                chop the sub string into words that each has the wordLength
                for (int k = 0; k <= subStringLength - wordLength; k += wordLength) {
                    if (wordFrequencyCopy.containsKey(currentSubString.substring(k, k + wordLength))) {
                        wordFrequencyCopy.put(currentSubString.substring(k, k + wordLength), wordFrequencyCopy.get(currentSubString.substring(k, k + wordLength)) - 1);
                    } else {
                        kRecorder = k;
                        matched = false;
                        break;
                    }
                }

                if (matched) {
//                    check wordFrequencyCopy and all key's values are 0
                    boolean allZeroed = true;
                    for (String key : wordFrequencyCopy.keySet()) {
                        if (wordFrequencyCopy.get(key) != 0) {
                            allZeroed = false;
//                            j = j+subStringLength-wordLength;
                            break;
                        }
                    }

                    if (allZeroed) {
                        result.add(j);
                    }

                }
//                if not matched, start from the word right behind the last non-matching word
                else {
                    j = kRecorder + j;
                }
            }
        }

        return result;
    }
}
