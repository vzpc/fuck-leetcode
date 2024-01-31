package org.example.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }
            dfs(nums, 0, new ArrayList<>(), result);
            return result;
        }

        private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
            if (index == nums.length) {
                result.add(new ArrayList<>(subset));
                return;
            }
            subset.add(nums[index]);
            dfs(nums, index + 1, subset, result);
            subset.remove(subset.size() - 1);
            dfs(nums, index + 1, subset, result);
        }

    }
}
