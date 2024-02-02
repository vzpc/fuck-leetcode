package org.example.bitmanipulation;

public class BitwiseANDOfNumbersRange {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int result = solution.rangeBitwiseAnd(5, 7);
        System.out.println(result);
    }

    private static class Solution {

        public int rangeBitwiseAnd(int left, int right) {
            int shift = 0;
            while (left < right) {
                left >>= 1;
                right >>= 1;
                shift++;
            }
            return left << shift;
        }

    }
}
