package org.example.linkedlist;

public class MergeTwoSortedLists {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode result = solution.mergeTwoLists(list1, list2);
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

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            ListNode head = new ListNode(0, null);;
            ListNode pointer = head;
            while (true) {
                if (list1.val <= list2.val) {
                    pointer.next = list1;
                    list1 = list1.next;
                } else {
                    pointer.next = list2;
                    list2 = list2.next;
                }
                pointer = pointer.next;
                if (list1 == null) {
                    pointer.next = list2;
                    break;
                }
                if (list2 == null) {
                    pointer.next = list1;
                    break;
                }
            }
            return head.next;
        }
    }
}
