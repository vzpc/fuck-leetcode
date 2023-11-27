package org.example.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        List<List<Integer>> result = solution.pathSum(root, 5);
        for (List<Integer> path: result) {
            for (Integer node: path) {
                System.out.print(node + ",");
            }
            System.out.println();
        }
    }

    private static class Solution {

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            if (root.left == null && root.right == null && root.val == targetSum) {
                List<Integer> path = new ArrayList<>();
                path.add(root.val);
                result.add(path);
                return result;
            }
            List<List<Integer>> leftResult = pathSum(root.left, targetSum - root.val);
            List<List<Integer>> rightResult = pathSum(root.right, targetSum - root.val);
            for (List<Integer> path: leftResult) {
                path.add(0, root.val);
                result.add(path);
            }
            for (List<Integer> path: rightResult) {
                path.add(0, root.val);
                result.add(path);
            }
            return result;
        }
    }
}
