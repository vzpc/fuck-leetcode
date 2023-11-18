package org.example.tree;

public class UniqueBinarySearchTrees {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int result = solution.numTrees(3);
        System.out.println(result);
    }

    private static class Solution {

        public int numTrees(int n) {
            int[] result = new int[n + 1];
            result[0] = 1;
            result[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    result[i] += result[j] * result[i - j - 1];
                }
            }
            return result[n];
        }
    }
}
