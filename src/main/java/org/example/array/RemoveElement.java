package org.example.array;

public class RemoveElement {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int result = solution.removeElement(nums, 3);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    private static class Solution {

        public int removeElement(int[] nums, int val) {
            if (nums.length == 0) {
                return 0;
            }
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[result] = nums[i];
                    result++;
                }
            }
            return result;
        }
    }
}
