package org.example.string;

import java.util.ArrayList;
import java.util.List;

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
            List<String> results = new ArrayList<>();
            StringBuffer zero = new StringBuffer();
            for (int i = num2.length() - 1; i >= 0; i--) {
                int carry = 0;
                if (i < num2.length() - 1) {
                    zero.append("0");
                }
                StringBuffer result = new StringBuffer();
                result.append(zero);
                for (int j = num1.length() - 1; j >= 0; j--) {
                    int product = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + carry;
                    result.append(product % 10);
                    carry = product / 10;
                }
                if (carry > 0) {
                    result.append(carry);
                }
                results.add(result.reverse().toString());
            }
            StringBuffer result = new StringBuffer();
            int carry = 0;
            for (int i = 0; i < results.get(results.size() - 1).length(); i++) {
                int sum = carry;
                for (String s : results) {
                    if (i < s.length()) {
                        sum += s.charAt(s.length() - 1 - i) - '0';
                    }
                }
                result.append(sum % 10);
                carry = sum / 10;
            }
            if (carry > 0) {
                result.append(carry);
            }
            return result.reverse().toString();
        }
    }
}
