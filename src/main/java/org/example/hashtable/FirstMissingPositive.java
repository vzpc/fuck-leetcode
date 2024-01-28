package org.example.hashtable;

public class FirstMissingPositive {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        int result = solution.firstMissingPositive(nums);
        System.out.println(result);
    }

    private static class Solution {

        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, nums[i] - 1, i);
                }
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return n + 1;
        }

        private void swap(int[] nums, int i, int j) {
            if (i == j) {
                return;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
