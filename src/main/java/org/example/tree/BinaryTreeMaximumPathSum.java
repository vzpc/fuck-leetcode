package org.example.tree;

public class BinaryTreeMaximumPathSum {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        int result = solution.maxPathSum(root);
        System.out.println(result);
    }

    private static class Solution {

        private int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return maxSum;
        }

        public int maxGain(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftGain = Math.max(maxGain(node.left), 0);
            int rightGain = Math.max(maxGain(node.right), 0);
            int newPathSum = node.val + leftGain + rightGain;
            maxSum = Math.max(maxSum, newPathSum);
            return node.val + Math.max(leftGain, rightGain);
        }
    }
}
