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
            ListNode result = new ListNode(Integer.MIN_VALUE, null);
            ListNode pointer = head;
            while (pointer != null) {
                ListNode pointer1 = result;
                ListNode pointer2 = result.next;
                while (pointer2 != null) {
                    if (pointer.val >= pointer1.val && pointer.val <= pointer2.val) {
                        pointer1.next = new ListNode(pointer.val, pointer2);
                        break;
                    } else {
                        pointer1 = pointer1.next;
                        pointer2 = pointer2.next;
                    }
                }
                if (pointer2 == null) {
                    pointer1.next = new ListNode(pointer.val, null);
                }
                pointer = pointer.next;
            }
            return result.next;
        }
    }
}
