package org.example.string;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String result = solution.convert(s, 3);
        System.out.print(result);
    }

    private static class Solution {

        public String convert(String s, int numRows) {
            if (numRows == 1 || numRows >= s.length()) {
                return s;
            }
            // 假设有K个N(将不足的部分补齐后)，那么最后一个字符的下标应该为N+(N-2+N)*K-1=(N-1)*(2K+1)，
            // 因此一定有s.length()<=(N-1)*(2K+1)，
            // 由此根据s的长度可以倒推出K，然后从0遍历K。
            int k = (s.length() / (numRows - 1)) / 2;
            if ((numRows - 1) * (2 * k + 1) < s.length()) {
                k++;
            }
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j <= k; j++) {
                int index = 2 * (numRows - 1) * j;
                if (index < s.length()) {
                    sb.append(s.charAt(index));
                }
            }
            if (numRows > 2) {
                for (int i = 1; i < numRows - 1; i++) {
                    if (i < s.length()) {
                        sb.append(s.charAt(i));
                    } else {
                        break;
                    }
                    for (int j = 1; j <= k; j++) {
                        int index1 = 2 * (numRows - 1) * j - i;
                        if (index1 < s.length()) {
                            sb.append(s.charAt(index1));
                        }
                        int index2 = 2 * (numRows - 1) * j + i;
                        if (index2 < s.length()) {
                            sb.append(s.charAt(index2));
                        }
                    }
                }
            }
            for (int j = 0; j <= k; j++) {
                int index = (numRows - 1) * (2 * j + 1);
                if (index < s.length()) {
                    sb.append(s.charAt(index));
                }
            }
            return sb.toString();
        }
    }
}
