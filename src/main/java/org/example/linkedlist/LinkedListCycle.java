package org.example.linkedlist;

public class LinkedListCycle {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, head);
        boolean result = solution.hasCycle(head);
        System.out.println(result);
    }

    private static class Solution {

        public boolean hasCycle(ListNode head) {
            ListNode pointer1 = head, pointer2 = head;
            while (pointer1 != null && pointer2 != null) {
                pointer1 = pointer1.next;
                if (pointer2.next != null) {
                    pointer2 = pointer2.next.next;
                } else {
                    return false;
                }
                if (pointer1 == pointer2) {
                    return true;
                }
            }

            return false;
        }
    }
}
