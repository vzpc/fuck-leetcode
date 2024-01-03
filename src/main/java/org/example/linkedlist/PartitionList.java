package org.example.linkedlist;

public class PartitionList {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null))))));
        ListNode result = solution.partition(head, 3);
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

        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode list1 = new ListNode(0, null), list2 = new ListNode(0, null);
            ListNode pointer1 = list1;
            ListNode pointer2 = list2;
            while (head != null) {
                if (head.val < x) {
                    pointer1.next = head;
                    pointer1 = pointer1.next;
                } else {
                    pointer2.next = head;
                    pointer2 = pointer2.next;
                }
                head = head.next;
            }
            pointer2.next = null;
            pointer1.next = list2.next;
            return list1.next;
        }
    }
}
