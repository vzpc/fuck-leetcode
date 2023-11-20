package org.example.tree;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, null), new TreeNode(4, new TreeNode(2, null, null), null));
        solution.recoverTree(root);
        List<Integer> preorderTraversalResult = preorderTraversal(root);
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

        public void recoverTree(TreeNode root) {
            TreeNode x, y, pred, predecessor;
            x = y = pred = predecessor = null;
            while (root != null) {
                if (root.left != null) {
                    predecessor = root.left;
                    while (predecessor.right != null && predecessor.right != root) {
                        predecessor = predecessor.right;
                    }
                    if (predecessor.right == null) {
                        predecessor.right = root;
                        root = root.left;
                    } else {
                        if (pred != null && root.val < pred.val) {
                            y = root;
                            if (x == null) {
                                x = pred;
                            }
                        }
                        pred = root;
                        predecessor.right = null;
                        root = root.right;
                    }
                } else {
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) {
                            x = pred;
                        }
                    }
                    pred = root;
                    root = root.right;
                }
            }
            swap(x, y);
        }

        public void swap(TreeNode x, TreeNode y) {
            Integer temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }
}
