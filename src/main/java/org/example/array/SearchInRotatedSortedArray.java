package org.example.array;

public class SearchInRotatedSortedArray {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int result = solution.search(nums, 0);
        System.out.print(result);
    }

    private static class Solution {

        public int search(int[] nums, int target) {
            int start = 0, end = nums.length - 1;
            int mid;
            while (start <= end) {
                mid = (start + end) / 2;
                if (target == nums[mid]) {
                    return mid;
                }
                if (nums[mid] > nums[start]) {
                    if (target > nums[mid]) {
                        start = mid + 1;
                    } else {
                        if (target > nums[start]) {
                            end = mid - 1;
                        } else if (target == nums[start]) {
                            return start;
                        } else {
                            start = mid + 1;
                        }
                    }
                } else if (nums[mid] < nums[start]) {
                    if (target < nums[mid]) {
                        end = mid - 1;
                    } else {
                        if (target > nums[end]) {
                            end = mid - 1;
                        } else if (target == nums[end]) {
                            return end;
                        } else {
                            start = mid + 1;
                        }
                    }
                } else {
                    if (target == nums[end]) {
                        return end;
                    } else {
                        return -1;
                    }
                }
            }
            return -1;
        }
    }
}
