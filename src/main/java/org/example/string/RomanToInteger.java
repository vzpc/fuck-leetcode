package org.example.string;

public class RomanToInteger {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int result = solution.romanToInt("MDLXX");
        System.out.print(result);
    }

    private static class Solution {

        public int romanToInt(String s) {
            int result = 0;
            int pointer = 0;
            while (pointer < s.length() && s.charAt(pointer) == 'M') {
                result += 1000;
                pointer++;
            }
            if (pointer < s.length() - 1 && s.charAt(pointer) == 'C' && s.charAt(pointer + 1) == 'M') {
                result += 900;
                pointer += 2;
            }
            if (pointer < s.length() && s.charAt(pointer) == 'D') {
                result += 500;
                pointer++;
            }
            if (pointer < s.length() - 1 && s.charAt(pointer) == 'C' && s.charAt(pointer + 1) == 'D') {
                result += 400;
                pointer += 2;
            }
            while (pointer < s.length() && s.charAt(pointer) == 'C') {
                result += 100;
                pointer++;
            }
            if (pointer < s.length() - 1 && s.charAt(pointer) == 'X' && s.charAt(pointer + 1) == 'C') {
                result += 90;
                pointer += 2;
            }
            if (pointer < s.length() && s.charAt(pointer) == 'L') {
                result += 50;
                pointer++;
            }
            if (pointer < s.length() - 1 && s.charAt(pointer) == 'X' && s.charAt(pointer + 1) == 'L') {
                result += 40;
                pointer += 2;
            }
            while (pointer < s.length() && s.charAt(pointer) == 'X') {
                result += 10;
                pointer++;
            }
            if (pointer < s.length() - 1 && s.charAt(pointer) == 'I' && s.charAt(pointer + 1) == 'X') {
                result += 9;
                pointer += 2;
            }
            if (pointer < s.length() && s.charAt(pointer) == 'V') {
                result += 5;
                pointer++;
            }
            if (pointer < s.length() - 1 && s.charAt(pointer) == 'I' && s.charAt(pointer + 1) == 'V') {
                result += 4;
                pointer++;
            }
            while (pointer < s.length() && s.charAt(pointer) == 'I') {
                result += 1;
                pointer++;
            }
            return result;
        }
    }
}
