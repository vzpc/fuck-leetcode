package org.example.string;

public class LongestPalindromicSubstring {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String s = "babad";
        String result = solution.longestPalindrome(s);
        System.out.print(result);
    }

    private static class Solution {

        public String longestPalindrome(String s) {
            if (s.length() == 1) {
                return s;
            }
            boolean[][] palindromeRecord = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                palindromeRecord[i][i] = true;
            }
            int start = 0, end = 0, length = 0;
            for (int step = 2; step <= s.length(); step++) {
                for (int i = 0; i < s.length(); i++) {
                    int j = i + step - 1;
                    if (j >= s.length()) {
                        break;
                    }
                    if (s.charAt(i) != s.charAt(j)) {
                        palindromeRecord[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            palindromeRecord[i][j] = true;
                        } else {
                            palindromeRecord[i][j] = palindromeRecord[i + 1][j - 1];
                        }
                    }
                    if (palindromeRecord[i][j] && step > length) {
                        length = step;
                        start = i;
                        end = j;
                    }
                }
            }
            return s.substring(start, end + 1);
        }
    }
}
