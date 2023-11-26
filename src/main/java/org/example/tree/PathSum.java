package org.example.tree;

public class PathSum {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        boolean result = solution.hasPathSum(root, 5);
        System.out.println(result);
    }

    private static class Solution {

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null && root.val == targetSum) {
                return true;
            }
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }
}
