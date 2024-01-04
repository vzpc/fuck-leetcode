package org.example.array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> result = solution.combinationSum(candidates, 7);
        for (List<Integer> combination : result) {
            for (Integer element : combination) {
                System.out.print(element + ",");
            }
            System.out.println();
        }
    }

    private static class Solution {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> combinations = new ArrayList<>();
            dfs(candidates, target, 0, new ArrayList<>(), combinations);
            return combinations;
        }

        public void dfs(int[] candidates, int target, int index, List<Integer> combination, List<List<Integer>> combinations) {
            if (target == 0) {
                combinations.add(new ArrayList<>(combination));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                if (target - candidates[i] >= 0) {
                    combination.add(candidates[i]);
                    dfs(candidates, target - candidates[i], i, combination, combinations);
                    combination.remove(combination.size() - 1);
                }
            }
        }
    }
}
