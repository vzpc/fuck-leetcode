package org.example.linkedlist;

public class ReorderList {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        solution.reorderList(head);
        while (true) {
            System.out.print(head.val);
            if (head.next != null) {
                head = head.next;
            } else {
                break;
            }
        }
    }

    private static class Solution {

        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            ListNode middleNode = findMiddleNode(head);
            ListNode rightNode = reverseList(middleNode.next);
            middleNode.next = null;
            mergeList(head, rightNode);
        }

        public ListNode findMiddleNode(ListNode head) {
            ListNode pointer1 = head, pointer2 = head;
            while (pointer1 != null && pointer2 != null) {
                if (pointer2.next != null) {
                    pointer2 = pointer2.next.next;
                } else {
                    break;
                }
                pointer1 = pointer1.next;
            }
            return pointer1;
        }

        public ListNode reverseList(ListNode head) {
            ListNode prev = null, curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        public void mergeList(ListNode listNode1, ListNode listNode2) {
            ListNode pointer1 = listNode1, pointer2 = listNode2;
            while (pointer1 != null && pointer2 != null) {
                ListNode next1 = pointer1.next;
                ListNode next2 = pointer2.next;
                pointer1.next = pointer2;
                pointer2.next = next1;
                pointer1 = next1;
                pointer2 = next2;
            }
        }
    }
}
