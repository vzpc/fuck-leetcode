package org.example.string;

public class MultiplyStrings {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String result = solution.multiply("123", "456");
        System.out.println(result);
    }

    private static class Solution {

        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            int[] result = new int[num1.length() + num2.length()];
            for (int i = 0; i < num1.length(); i++) {
                for (int j = 0; j < num2.length(); j++) {
                    int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    result[i + j + 1] += product;
                }
            }
            for (int i = result.length - 1; i > 0; i--) {
                result[i - 1] += result[i] / 10;
                result[i] = result[i] % 10;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                if (i == 0 && result[i] == 0) {
                    continue;
                }
                stringBuffer.append(result[i]);
            }
            return stringBuffer.toString();
        }
    }
}
