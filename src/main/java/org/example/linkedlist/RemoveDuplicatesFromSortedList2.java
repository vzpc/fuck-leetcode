package org.example.linkedlist;

public class RemoveDuplicatesFromSortedList2 {

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
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(-1, head);
            ListNode prev = dummy;
            ListNode pointer = head;
            while (pointer != null) {
                if (pointer.next != null) {
                    if (pointer.val != pointer.next.val) {
                        if (prev.next == pointer) {
                            prev = pointer;
                        } else {
                            prev.next = pointer.next;
                        }
                    }
                } else {
                    if (prev.next == pointer) {
                        prev = pointer;
                    } else {
                        prev.next = pointer.next;
                    }
                }
                pointer = pointer.next;
            }
            return dummy.next;
        }
    }
}
