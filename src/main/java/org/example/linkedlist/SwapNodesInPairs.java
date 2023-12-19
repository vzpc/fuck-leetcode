package org.example.linkedlist;

public class SwapNodesInPairs {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode result = solution.swapPairs(head);
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

        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pointer = dummy;
            while (pointer.next != null && pointer.next.next != null) {
                ListNode node1 = pointer.next;
                ListNode node2 = pointer.next.next;
                pointer.next = node2;
                node1.next = node2.next;
                node2.next = node1;
                pointer = node1;
            }
            return dummy.next;
        }
    }
}
