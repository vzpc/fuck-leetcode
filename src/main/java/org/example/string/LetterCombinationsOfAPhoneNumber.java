package org.example.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        List<String> result = solution.letterCombinations("23");
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static class Solution {

        private Map<Character, char[]> phoneMap = new HashMap() {{
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r', 's'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y', 'z'});
        }};

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return new ArrayList<>();
            }

            return letterCombinations(digits.toCharArray(), 0);
        }

        public List<String> letterCombinations(char[] digits, int index) {
            List<String> result = new ArrayList<>();
            if (index == digits.length) {
                return result;
            }
            char[] letters = phoneMap.get(digits[index]);
            for (char letter : letters) {
                List<String> subResult = letterCombinations(digits, index + 1);
                if (subResult.isEmpty()) {
                    result.add(String.valueOf(letter));
                } else {
                    for (String s : subResult) {
                        result.add(letter + s);
                    }
                }
            }
            return result;
        }
    }
}
