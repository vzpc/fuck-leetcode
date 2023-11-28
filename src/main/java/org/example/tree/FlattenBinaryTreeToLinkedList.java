package org.example.tree;

public class FlattenBinaryTreeToLinkedList {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)), new TreeNode(5, null, new TreeNode(6, null, null)));
        solution.flatten(root);
        while (root != null) {
            System.out.print(root.val + ",");
            root = root.right;
        }
    }

    private static class Solution {

        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null) {
                root = root.right;
            }
            root.right = temp;
            flatten(temp);
        }
    }
}
