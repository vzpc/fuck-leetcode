package org.example.linkedlist;

public class OddEvenLinkedList {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode result = solution.oddEvenList(head);
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

        public ListNode oddEvenList(ListNode head) {
            int index = 1;
            ListNode oddHead = new ListNode(-1), evenHead = new ListNode(-1);
            ListNode oddPointer = oddHead, evenPointer = evenHead;
            while (head != null) {
                if (index % 2 == 1) {
                    oddPointer.next = head;
                    oddPointer = oddPointer.next;
                } else {
                    evenPointer.next = head;
                    evenPointer = evenPointer.next;
                }
                head = head.next;
                index++;
            }
            evenPointer.next = null;
            oddPointer.next = evenHead.next;
            return oddHead.next;
        }
    }
}
