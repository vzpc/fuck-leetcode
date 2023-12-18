package org.example.linkedlist;

public class AddTwoNumbers2 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode list1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))));
        ListNode list2 = new ListNode(9, null);
        ListNode result = solution.addTwoNumbers(list1, list2);
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

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = reverseList(l1);
            l2 = reverseList(l2);
            ListNode dummy = new ListNode(-1);
            ListNode pointer = dummy;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int sum = carry;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                pointer.next = new ListNode(sum % 10);
                pointer = pointer.next;
                carry = sum / 10;
            }
            if (carry > 0) {
                pointer.next = new ListNode(carry);
            }
            return reverseList(dummy.next);
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
    }
}

