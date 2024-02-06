package org.example.bitmanipulation;

public class SingleNumber {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int result = solution.singleNumber(nums);
        System.out.println(result);
    }

    private static class Solution {

        public int singleNumber(int[] nums) {
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                result ^= nums[i];
            }
            return result;
        }

    }
}
