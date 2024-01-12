package org.example.math;

public class DivideTwoIntegers {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 1;
        int result = solution.divide(dividend, divisor);
        System.out.println(result);
    }

    private static class Solution {

        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE) {
                if (divisor == -1) {
                    return Integer.MAX_VALUE;
                } else if (divisor == 1) {
                    return Integer.MIN_VALUE;
                }
            }
            if (divisor == Integer.MIN_VALUE) {
                return dividend == Integer.MIN_VALUE ? 1 : 0;
            }
            if (dividend == 0) {
                return 0;
            }
            boolean rev = false;
            if (dividend > 0) {
                dividend = -dividend;
                rev = !rev;
            }
            if (divisor > 0) {
                divisor = -divisor;
                rev = !rev;
            }

            int result = 0;
            while (dividend <= divisor) {
                int tempResult = 1;
                int tempDivisor = divisor;
                while (dividend <= (tempDivisor << 1)) {
                    if (tempDivisor <= (Integer.MIN_VALUE >> 1)) {
                        break;
                    }
                    tempResult = tempResult << 1;
                    tempDivisor = tempDivisor << 1;
                }
                dividend -= tempDivisor;
                result += tempResult;
            }
            return rev ? -result : result;
        }
    }
}
