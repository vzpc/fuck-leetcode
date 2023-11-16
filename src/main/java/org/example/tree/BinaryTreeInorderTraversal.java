package org.example.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        List<Integer> result = solution.inorderTraversal(root);
        for (Integer i: result) {
            System.out.println(i);
        }
    }

    private static class Solution {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorderTraversal(root, result);
            return result;
        }

        public void inorderTraversal(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                inorderTraversal(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                inorderTraversal(root.right, result);
            }
        }
    }
}
