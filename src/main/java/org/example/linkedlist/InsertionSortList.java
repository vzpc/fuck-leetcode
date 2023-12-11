package org.example.linkedlist;

public class InsertionSortList {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, null))));
        ListNode result = solution.insertionSortList(head);
        if (result != null) {
            while (true) {
                System.out.print(result.val);
                if (result.next != null) {
                    result = result.next;
                } else {
                    break;
                }
            }
        }
    }

    private static class Solution {

        public ListNode insertionSortList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode(0, head);
            ListNode lastSorted = head;
            ListNode pointer = head.next;
            while (pointer != null) {
                if (lastSorted.val <= pointer.val) {
                    lastSorted = lastSorted.next;
                } else {
                    ListNode prev = dummy;
                    while (prev.next.val <= pointer.val) {
                        prev = prev.next;
                    }
                    lastSorted.next = pointer.next;
                    pointer.next = prev.next;
                    prev.next = pointer;
                }
                pointer = lastSorted.next;
            }
            return dummy.next;
        }
    }
}
