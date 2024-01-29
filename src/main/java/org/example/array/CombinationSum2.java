package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = solution.combinationSum2(candidates, 8);
        for (List<Integer> combination : result) {
            for (Integer element : combination) {
                System.out.print(element + ",");
            }
            System.out.println();
        }
    }

    private static class Solution {

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> combinations = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, 0, new ArrayList<>(), combinations);
            return combinations;
        }

        public void dfs(int[] candidates, int target, int index, List<Integer> combination, List<List<Integer>> combinations) {
            if (target == 0) {
                combinations.add(new ArrayList<>(combination));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (target - candidates[i] >= 0) {
                    combination.add(candidates[i]);
                    dfs(candidates, target - candidates[i], i + 1, combination, combinations);
                    combination.remove(combination.size() - 1);
                }
            }
        }
    }
}
