package org.example.linkedlist;

public class ReverseLinkedList {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode result = solution.reverseList(head);
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

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            ListNode pointer1 = head, pointer2 = head.next;
            pointer1.next = null;
            while (pointer2 != null) {
                ListNode temp = pointer2.next;
                pointer2.next = pointer1;
                pointer1 = pointer2;
                pointer2 = temp;
            }
            return pointer1;
        }
    }
}
