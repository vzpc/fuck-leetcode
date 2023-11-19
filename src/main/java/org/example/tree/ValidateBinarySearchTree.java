package org.example.tree;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        boolean result = solution.isValidBST(root);
        System.out.println(result);
    }

    private static class Solution {

        public boolean isValidBST(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            double inorder = -Double.MAX_VALUE;
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.val <= inorder) {
                    return false;
                }
                inorder = root.val;
                root = root.right;
            }
            return true;
        }

    }
}
