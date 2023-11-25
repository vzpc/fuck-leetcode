package org.example.tree;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9, null)))));
        TreeNode result = solution.sortedListToBST(head);
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

        private ListNode golbalHead;

        public TreeNode sortedListToBST(ListNode head) {
            int length = getLength(head);
            golbalHead = head;
            return sortedListToBST(0, length - 1);
        }

        public int getLength(ListNode head) {
            int length = 0;
            while (head != null) {
                length++;
                head = head.next;
            }
            return length;
        }

        public TreeNode sortedListToBST(int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = (left + right + 1) / 2;
            TreeNode root = new TreeNode();
            root.left = sortedListToBST(left, mid - 1);
            root.val = golbalHead.val;
            golbalHead = golbalHead.next;
            root.right = sortedListToBST(mid + 1, right);
            return root;
        }
    }
}
