package org.example.array;

public class NextPermutation {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        solution.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    private static class Solution {

        public void nextPermutation(int[] nums) {
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i - 1] < nums[i]) {
                    this.reverseOrder(nums, i, nums.length - 1);
                    for (int j = i; j < nums.length; j++) {
                        if (nums[j] > nums[i - 1]) {
                            int temp = nums[j];
                            nums[j] = nums[i - 1];
                            nums[i - 1] = temp;
                            return;
                        }
                    }
                }
            }
            this.reverseOrder(nums, 0, nums.length - 1);
        }

        public void reverseOrder(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}
