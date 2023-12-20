package org.example.linkedlist;

public class RotateList {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode result = solution.rotateRight(head, 1);
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

        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            int length = 1;
            ListNode pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
                length++;
            }
            pointer.next = head;
            int step = length - k % length;
            while (step > 0) {
                pointer = pointer.next;
                step--;
            }
            ListNode newHead = pointer.next;
            pointer.next = null;
            return newHead;
        }
    }
}
