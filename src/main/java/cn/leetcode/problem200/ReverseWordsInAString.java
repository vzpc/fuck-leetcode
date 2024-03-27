package cn.leetcode.problem200;

public class ReverseWordsInAString {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String result = solution.reverseWords("  hello world  ");
        System.out.println(result);
    }

    private static class Solution {

        public String reverseWords(String s) {
            String[] tokens = s.trim().split("\\s+");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = tokens.length - 1; i > 0; i--) {
                stringBuilder.append(tokens[i]);
                stringBuilder.append(" ");
            }
            stringBuilder.append(tokens[0]);
            return stringBuilder.toString();
        }
    }
}
