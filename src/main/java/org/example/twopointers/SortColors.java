package org.example.twopointers;

public class SortColors {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    private static class Solution {

        public void sortColors(int[] nums) {
            int leftPointer = 0;
            int rightPointer = nums.length - 1;
            int currentPointer = 0;
            while (currentPointer <= rightPointer) {
                if (nums[currentPointer] == 0) {
                    swap(nums, leftPointer, currentPointer);
                    leftPointer++;
                    currentPointer++;
                } else if (nums[currentPointer] == 2) {
                    swap(nums, rightPointer, currentPointer);
                    rightPointer--;
                } else {
                    currentPointer++;
                }
            }
        }

        private void swap(int[] nums, int pointer1, int pointer2) {
            int temp = nums[pointer1];
            nums[pointer1] = nums[pointer2];
            nums[pointer2] = temp;
        }
    }
}
