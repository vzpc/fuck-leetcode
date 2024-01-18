package org.example.tree;

public class CountCompleteTreeNodes {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), null));
        int result = solution.countNodes(root);
        System.out.println(result);
    }

    private static class Solution {

        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int level = 0;
            TreeNode node = root;
            while (node.left != null) {
                level++;
                node = node.left;
            }
            int low = 1 << level, high = (1 << (level + 1)) - 1;
            while (low < high) {
                int mid = (high - low + 1) / 2 + low;
                if (exists(root, level, mid)) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }

        public boolean exists(TreeNode root, int level, int k) {
            int bits = 1 << (level - 1);
            TreeNode node = root;
            while (node != null && bits > 0) {
                if ((bits & k) == 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
                bits >>= 1;
            }
            return node != null;
        }
    }
}
