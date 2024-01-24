package org.example.linkedlist;

public class ReverseLinkedList2 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode result = solution.reverseBetween(head, 1, 2);
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

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right) {
                return head;
            }
            ListNode dummyNode = new ListNode(-1, head);
            ListNode pointer0 = null;
            ListNode pointer1 = dummyNode;
            int i = 0;
            while (i < left) {
                pointer0 = pointer1;
                pointer1 = pointer1.next;
                i++;
            }
            ListNode pointer2 = pointer1;
            ListNode pointer3 = pointer2.next;
            while (i < right) {
                ListNode temp = pointer3.next;
                pointer3.next = pointer2;
                pointer2 = pointer3;
                pointer3 = temp;
                i++;
            }
            pointer0.next = pointer2;
            pointer1.next = pointer3;
            return dummyNode.next;
        }
    }
}
