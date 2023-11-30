package org.example.tree;

import java.util.Deque;
import java.util.LinkedList;

public class SumRootToLeafNumbers {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int result = solution.sumNumbers(root);
        System.out.println(result);
    }

    private static class Solution {

        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int sum = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left == null && node.right == null) {
                        sum += node.val;
                    }
                    if (node.left != null) {
                        node.left.val += node.val * 10;
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        node.right.val += node.val * 10;
                        queue.add(node.right);
                    }
                }
            }
            return sum;
        }
    }
}
