package org.example.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode result = solution.buildTree(inorder, postorder);
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

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (postorder == null || postorder.length == 0) {
                return null;
            }
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }
            return buildTree(postorder, postorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] postorder, int postorderIndex, int inorderStart, int inorderEnd) {
            if (inorderStart > inorderEnd) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postorderIndex]);
            int inorderIndex = inorderIndexMap.get(postorder[postorderIndex]);
            root.right = buildTree(postorder, postorderIndex - 1, inorderIndex + 1, inorderEnd);
            root.left = buildTree(postorder, postorderIndex - inorderEnd + inorderIndex - 1, inorderStart, inorderIndex - 1);
            return root;
        }
    }
}
