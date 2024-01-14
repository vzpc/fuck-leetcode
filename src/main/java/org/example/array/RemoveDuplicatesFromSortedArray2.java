package org.example.array;

public class RemoveDuplicatesFromSortedArray2 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int result = solution.removeDuplicates(nums);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    private static class Solution {

        public int removeDuplicates(int[] nums) {
            if (nums.length == 1) {
                return 1;
            }
            int result = 0, count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[result] != nums[i]) {
                    result++;
                    nums[result] = nums[i];
                    count = 1;
                } else if (count > 0) {
                    result++;
                    nums[result] = nums[i];
                    count--;
                }
            }
            return result + 1;
        }
    }
}
