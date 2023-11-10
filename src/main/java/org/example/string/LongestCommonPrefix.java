package org.example.string;

public class LongestCommonPrefix {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String result = solution.longestCommonPrefix(strs);
        System.out.print(result);
    }

    private static class Solution {

        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 1) {
                return strs[0];
            }
            StringBuffer sb = new StringBuffer();
            int index = 0;
            while (true) {
                boolean same = true;
                for (int i = 0; i < strs.length - 1; i++) {
                    if (strs[i].length() <= index || strs[i + 1].length() <= index) {
                        return sb.toString();
                    }
                    if (strs[i].charAt(index) != strs[i + 1].charAt(index)) {
                        return sb.toString();
                    }
                }
                if (same) {
                    sb.append(strs[0].charAt(index));
                    index++;
                }
            }
        }
    }
}
