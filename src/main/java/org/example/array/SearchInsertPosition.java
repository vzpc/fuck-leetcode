package org.example.array;

public class SearchInsertPosition {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int result = solution.searchInsert(nums, 5);
        System.out.print(result);
    }

    private static class Solution {

        public int searchInsert(int[] nums, int target) {
            int start = 0, end = nums.length - 1, mid;
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (nums[mid] < target) {
                    start = mid + 1;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
            return start;
        }
    }
}
