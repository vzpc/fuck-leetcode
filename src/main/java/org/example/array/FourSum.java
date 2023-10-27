package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = solution.fourSum(nums, 0);
        for (List<Integer> quad : result) {
            for (Integer element : quad) {
                System.out.print(element + ",");
            }
            System.out.println();
        }

        int[] nums2 = {1000000000, 1000000000, 1000000000, 1000000000};
        List<List<Integer>> result2 = solution.fourSum(nums2, -294967296);
        for (List<Integer> quad : result2) {
            for (Integer element : quad) {
                System.out.print(element + ",");
            }
            System.out.println();
        }
    }

    private static class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 4) {
                return result;
            }
            Arrays.sort(nums);
            int leftPointer, rightPointer;
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    leftPointer = j + 1;
                    rightPointer = nums.length - 1;
                    while (leftPointer < rightPointer) {
                        long sum = (long) nums[i] + nums[j] + nums[leftPointer] + nums[rightPointer];
                        if (sum == target) {
                            List<Integer> quad = new ArrayList<>();
                            quad.add(nums[i]);
                            quad.add(nums[j]);
                            quad.add(nums[leftPointer]);
                            quad.add(nums[rightPointer]);
                            result.add(quad);
                            int currentLeft = nums[leftPointer];
                            int currentRight = nums[rightPointer];
                            while (leftPointer < rightPointer && currentLeft == nums[leftPointer + 1]) {
                                leftPointer++;
                            }
                            leftPointer++;
                            while (leftPointer < rightPointer && currentRight == nums[rightPointer - 1]) {
                                rightPointer--;
                            }
                            rightPointer--;
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
                    }
                }
            }
            return result;
        }
    }
}
