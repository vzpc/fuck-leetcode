package org.example.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode result = solution.buildTree(preorder, inorder);
        List<Integer> preorderTraversalResult = preorderTraversal(result);
        for (Integer i : preorderTraversalResult) {
            System.out.print(i + ",");
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    public static void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left, result);
        }
        if (root.right != null) {
            preorderTraversal(root.right, result);
        }
    }

    private static class Solution {

        private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }
            return buildTree(preorder, 0, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int preorderIndex, int inorderStart, int inorderEnd) {
            if (inorderStart > inorderEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preorderIndex]);
            int inorderIndex = inorderIndexMap.get(preorder[preorderIndex]);
            root.left = buildTree(preorder, preorderIndex + 1, inorderStart, inorderIndex - 1);
            root.right = buildTree(preorder, preorderIndex + inorderIndex - inorderStart + 1, inorderIndex + 1, inorderEnd);
            return root;
        }
    }
}
