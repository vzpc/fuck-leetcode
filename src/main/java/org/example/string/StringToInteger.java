package org.example.string;

public class StringToInteger {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int result = solution.myAtoi("   -42");
        System.out.print(result);
    }

    private static class Solution {

        public int myAtoi(String s) {
            s = s.trim();
            if (s.length() == 0) {
                return 0;
            }
            int pointer = 0;
            boolean positive = true;
            if (s.charAt(0) == '+') {
                positive = true;
                pointer++;
            } else if (s.charAt(0) == '-') {
                positive = false;
                pointer++;
            }
            long result = 0;
            while (pointer < s.length()) {
                if (s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9') {
                    result = result * 10 + (s.charAt(pointer) - '0');
                    if (positive && result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    if (!positive && -result < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                    pointer++;
                } else {
                    break;
                }
            }
            if (!positive) {
                result = -result;
            }
            return (int) result;
        }
    }
}
