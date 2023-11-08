package org.example.string;

/**
 *
 * I   1
 * V   5
 * X   10
 * L   50
 * C   100
 * D   500
 * M   1000
 */
public class IntegerToRoman {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String result = solution.intToRoman(3);
        System.out.print(result);
    }

    private static class Solution {

        public String intToRoman(int num) {
            StringBuffer sb = new StringBuffer();
            int countOfM = num / 1000;
            for (int i = 0; i < countOfM; i++) {
                sb.append("M");
            }
            num = num % 1000;
            if (num >= 900) {
                sb.append("CM");
                num -= 900;
            } else if (num >= 500) {
                sb.append("D");
                num -= 500;
                int countOfC = num / 100;
                for (int i = 0; i < countOfC; i++) {
                    sb.append("C");
                }
                num = num % 100;
            } else if (num >= 400) {
                sb.append("CD");
                num -= 400;
            } else {
                int countOfC = num / 100;
                for (int i = 0; i < countOfC; i++) {
                    sb.append("C");
                }
                num = num % 100;
            }
            if (num >= 90) {
                sb.append("XC");
                num -= 90;
            } else if (num >= 50) {
                sb.append("L");
                num -= 50;
                int countOfX = num / 10;
                for (int i = 0; i < countOfX; i++) {
                    sb.append("X");
                }
                num = num % 10;
            } else if (num >= 40) {
                sb.append("XL");
                num -= 40;
            } else {
                int countOfX = num / 10;
                for (int i = 0; i < countOfX; i++) {
                    sb.append("X");
                }
                num = num % 10;
            }
            if (num == 9) {
                sb.append("IX");
            } else if (num >= 5) {
                sb.append("V");
                num -= 5;
                for (int i = 0; i < num; i++) {
                    sb.append("I");
                }
            } else if (num == 4) {
                sb.append("IV");
            } else {
                for (int i = 0; i < num; i++) {
                    sb.append("I");
                }
            }
            return sb.toString();
        }
    }

}
