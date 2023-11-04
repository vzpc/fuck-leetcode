package org.example.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String s= "abcabcbb";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.print(result);
    }

    private static class Solution {

        public int lengthOfLongestSubstring(String s) {
            int result = 0;
            int pointer1 = 0, pointer2 = 0;
            Map<Character, Integer> occurrence = new HashMap<>();
            while (pointer2 < s.length()) {
                if (occurrence.containsKey(s.charAt(pointer2))) {
                    int oldOccurrence = occurrence.get(s.charAt(pointer2));
                    for (int i = pointer1; i <= oldOccurrence; i++) {
                        occurrence.remove(s.charAt(i));
                    }
                    occurrence.put(s.charAt(pointer2), pointer2);
                    pointer1 = oldOccurrence + 1;
                } else {
                    occurrence.put(s.charAt(pointer2), pointer2);
                    int length = (pointer2 - pointer1 + 1);
                    if (result < length) {
                        result = length;
                    }
                }
                pointer2++;
            }
            return result;
        }
    }
}
