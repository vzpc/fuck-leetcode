package org.example.linkedlist;

public class RemoveDuplicatesFromSortedList {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode result = solution.deleteDuplicates(head);
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

        public ListNode deleteDuplicates(ListNode head) {
            ListNode pointer = head;
            while (pointer != null && pointer.next != null) {
                if (pointer.val == pointer.next.val) {
                    pointer.next = pointer.next.next;
                } else {
                    pointer = pointer.next;
                }
            }
            return head;
        }
    }
}
