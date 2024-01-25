package org.example.twopointers;

public class ReverseWordsInAString {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String result = solution.reverseWords("the sky is blue");
        System.out.println(result);
    }

    private static class Solution {

        public String reverseWords(String s) {
            String[] words = s.trim().split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (int i = words.length - 1; i > 0; i--) {
                sb.append(words[i]).append(" ");
            }
            sb.append(words[0]);
            return sb.toString();
        }
    }
}
