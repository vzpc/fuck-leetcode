package org.example.tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal2 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        List<List<Integer>> result = solution.levelOrderBottom(root);
        for (List<Integer> level: result) {
            for (Integer node: level) {
                System.out.print(node + ",");
            }
            System.out.println();
        }
    }

    private static class Solution {

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                result.add(level);

            }
            Collections.reverse(result);
            return result;
        }
    }
}
