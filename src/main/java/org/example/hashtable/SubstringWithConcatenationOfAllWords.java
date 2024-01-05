package org.example.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String[] words = {"foo", "bar"};
        List<Integer> result = solution.findSubstring("barfoothefoobarman", words);
        for (Integer index : result) {
            System.out.print(index + ",");
        }
    }

    private static class Solution {

        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();
            if (s == null || s.length() == 0 || words == null || words.length == 0) {
                return result;
            }
            int wordLength = words[0].length();
            int wordCount = words.length;
            int totalLength = wordLength * wordCount;
            if (s.length() < totalLength) {
                return result;
            }
            for (int i = 0; i <= s.length() - totalLength; i++) {
                Map<String, Integer> wordCountMap = new HashMap<>();
                for (String word : words) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
                int j = i;
                while (j < i + totalLength) {
                    String word = s.substring(j, j + wordLength);
                    if (wordCountMap.containsKey(word)) {
                        int count = wordCountMap.get(word);
                        if (count == 1) {
                            wordCountMap.remove(word);
                        } else {
                            wordCountMap.put(word, count - 1);
                        }
                    } else {
                        break;
                    }
                    j += wordLength;
                }
                if (j == i + totalLength) {
                    result.add(i);
                }
            }
            return result;
        }
    }
}
