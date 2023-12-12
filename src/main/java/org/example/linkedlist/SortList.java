package org.example.linkedlist;

public class SortList {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, null))));
        ListNode result = solution.sortList(head);
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

        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            ListNode middleNode = findMiddleNode(head);
            ListNode rightNode = middleNode.next;
            middleNode.next = null;
            ListNode sortedLeft = sortList(head);
            ListNode sortedRight = sortList(rightNode);
            return mergeList(sortedLeft, sortedRight);
        }

        public ListNode findMiddleNode(ListNode head) {
            ListNode pointer0 = head, pointer1 = head, pointer2 = head;
            while (pointer1 != null && pointer2 != null) {
                if (pointer2.next != null) {
                    pointer2 = pointer2.next.next;
                } else {
                    break;
                }
                pointer0 = pointer1;
                pointer1 = pointer1.next;
            }
            return pointer0;
        }

        public ListNode mergeList(ListNode listNode1, ListNode listNode2) {
            ListNode dummy = new ListNode(0, listNode1);
            ListNode pointer0 = dummy;
            ListNode pointer1 = listNode1, pointer2 = listNode2;
            while (pointer1 != null && pointer2 != null) {
                if (pointer1.val <= pointer2.val) {
                    if (pointer1.next == null) {
                        pointer1.next = pointer2;
                        break;
                    }
                    pointer0 = pointer1;
                    pointer1 = pointer1.next;
                } else {
                    ListNode next2 = pointer2.next;
                    pointer2.next = pointer1;
                    pointer0.next = pointer2;
                    pointer0 = pointer2;
                    pointer2 = next2;
                }
            }
            return dummy.next;
        }
    }
}
