package org.example.array;

import java.util.Arrays;

public class ThreeSumClosest {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int result = solution.threeSumClosest(nums, 1);
        System.out.println(result);
    }

    private static class Solution {

        public int threeSumClosest(int[] nums, int target) {
            int result = nums[0] + nums[1] + nums[2];
            Arrays.sort(nums);
            int leftPointer, rightPointer;
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                leftPointer = i + 1;
                rightPointer = nums.length - 1;
                while (leftPointer < rightPointer) {
                    int sum = nums[i] + nums[leftPointer] + nums[rightPointer];
                    if (sum == target) {
                        return sum;
                    } else if (sum > target) {
                        int currentRight = nums[rightPointer];
                        while (leftPointer < rightPointer && currentRight == nums[rightPointer - 1]) {
                            rightPointer--;
                        }
                        rightPointer--;
                    } else {
                        int currentLeft = nums[leftPointer];
                        while (leftPointer < rightPointer && currentLeft == nums[leftPointer + 1]) {
                            leftPointer++;
                        }
                        leftPointer++;
                    }
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                }
            }
            return result;
        }
    }
}
