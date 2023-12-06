package org.example.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, head);
        ListNode result = solution.detectCycle(head);
        System.out.println(result.val);
    }

    private static class Solution {

        private Set<ListNode> visited = new HashSet<>();

        public ListNode detectCycle(ListNode head) {
            ListNode pointer = head;
            while (pointer != null) {
                if (visited.contains(pointer)) {
                    return pointer;
                } else {
                    visited.add(pointer);
                }
                pointer = pointer.next;
            }
            return null;
        }
    }
}
