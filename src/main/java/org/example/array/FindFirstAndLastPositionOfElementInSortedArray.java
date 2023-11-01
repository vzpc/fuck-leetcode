package org.example.array;

public class FindFirstAndLastPositionOfElementInSortedArray {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = solution.searchRange(nums, 8);
        System.out.print(result[0] + "," + result[1]);
    }

    private static class Solution {

        public int[] searchRange(int[] nums, int target) {
            int start = 0, end = nums.length - 1, mid;
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (nums[mid] < target) {
                    start = mid + 1;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid;
                    while (start >= 0 && nums[start] == target) {
                        start--;
                    }
                    end = mid;
                    while (end < nums.length && nums[end] == target) {
                        end++;
                    }
                    return new int[]{start + 1, end - 1};
                }
            }
            return new int[]{-1, -1};
        }
    }
}
