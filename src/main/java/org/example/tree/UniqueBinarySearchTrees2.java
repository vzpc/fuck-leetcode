package org.example.tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        List<TreeNode> result = solution.generateTrees(3);
        for (TreeNode treeNode : result) {
            List<Integer> inorderTraversalResult = preorderTraversal(treeNode);
            for (Integer i : inorderTraversalResult) {
                System.out.print(i + ",");
            }
            System.out.println();
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

        public List<TreeNode> generateTrees(int n) {
            return generateTreesForRange(1, n);
        }

        public List<TreeNode> generateTreesForRange(int start, int end) {
            List<TreeNode> result = new ArrayList<>();
            if (start > end) {
                result.add(null);
            } else {
                for (int i = start; i <= end; i++) {
                    List<TreeNode> leftNodes = generateTreesForRange(start, i - 1);
                    List<TreeNode> rightNodes = generateTreesForRange(i + 1, end);
                    for (TreeNode leftNode : leftNodes) {
                        for (TreeNode rightNode : rightNodes) {
                            TreeNode root = new TreeNode(i, leftNode, rightNode);
                            result.add(root);
                        }
                    }
                }
            }
            return result;
        }
    }
}