package org.example.hashtable;

public class MinimumWindowSubstring {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String result = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }

    private static class Solution {

        public String minWindow(String s, String t) {
            int[] need = new int[128];
            int[] window = new int[128];
            for (char c : t.toCharArray()) {
                need[c]++;
            }
            int left = 0;
            int right = 0;
            int valid = 0;
            int start = 0;
            int len = Integer.MAX_VALUE;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                if (need[c] > 0) {
                    window[c]++;
                    if (window[c] <= need[c]) {
                        valid++;
                    }
                }
                while (valid == t.length()) {
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }
                    char d = s.charAt(left);
                    left++;
                    if (need[d] > 0) {
                        if (window[d] <= need[d]) {
                            valid--;
                        }
                        window[d]--;
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }

    }
}
