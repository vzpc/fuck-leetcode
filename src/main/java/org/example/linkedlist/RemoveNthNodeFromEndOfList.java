package org.example.linkedlist;

public class RemoveNthNodeFromEndOfList {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode result = solution.removeNthFromEnd(head, 2);
        while (true) {
            System.out.print(result.val);
            if (result.next != null) {
                result = result.next;
            } else {
                break;
            }
        }
    }

    private static class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode pointer1 = head, pointer2 = dummy;
            for (int i = 0; i < n; i++) {
                pointer1 = pointer1.next;
            }
            while (pointer1 != null) {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            pointer2.next = pointer2.next.next;
            return dummy.next;
        }
    }
}
