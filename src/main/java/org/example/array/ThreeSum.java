package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        for (List<Integer> triple : result) {
            for (Integer element : triple) {
                System.out.print(element + ",");
            }
            System.out.println();
        }
    }

    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return result;
            }
            Arrays.sort(nums);
            int leftPointer, rightPointer;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                leftPointer = i + 1;
                rightPointer = nums.length - 1;
                while (leftPointer < rightPointer) {
                    int sum = nums[i] + nums[leftPointer] + nums[rightPointer];
                    if (sum == 0) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(nums[i]);
                        triple.add(nums[leftPointer]);
                        triple.add(nums[rightPointer]);
                        result.add(triple);
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
                    } else if (sum > 0) {
                        rightPointer--;
                    } else {
                        leftPointer++;
                    }
                }
            }
            return result;
        }
    }
}
