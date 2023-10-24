package org.example.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 3;
        nums[1] = 2;
        nums[2] = 4;
        int[] result = solution.twoSum(nums, 6);
        System.out.println(result[0] + ", " + result[1]);
    }

    private static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numsMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (numsMap.containsKey(target - nums[i])) {
                    int result[] = new int[2];
                    result[0] = i;
                    result[1] = numsMap.get(target - nums[i]);
                    return result;
                } else {
                    numsMap.put(nums[i], i);
                }
            }
            return null;
        }
    }
}

