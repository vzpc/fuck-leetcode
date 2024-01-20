package org.example.hashtable;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int result = solution.longestConsecutive(nums);
        System.out.println(result);
    }

    private static class Solution {

        public int longestConsecutive(int[] nums) {
            int result = 0;
            Set<Integer> numsSet = new HashSet<>();
            for (int num: nums) {
                numsSet.add(num);
            }
            for (int num: nums) {
                if (numsSet.contains(num - 1)) {
                    continue;
                }
                int consecutiveLength = 1;
                while (numsSet.contains(++num)) {
                    consecutiveLength++;
                }
                if (consecutiveLength > result) {
                    result = consecutiveLength;
                }
            }
            return result;
        }
    }
}
