package org.example.linkedlist;

public class DeleteNodeInALinkedList {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(3, null));
        ListNode head = new ListNode(4, new ListNode(2, node));
        solution.deleteNode(node);
        if (head!= null) {
            while (true) {
                System.out.print(head.val);
                if (head.next != null) {
                    head = head.next;
                } else {
                    break;
                }
            }
        }
    }

    private static class Solution {

        public void deleteNode(ListNode node) {
            if (node == null) {
                return;
            }
            if (node.next == null) {
                node = null;
                return;
            }
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
