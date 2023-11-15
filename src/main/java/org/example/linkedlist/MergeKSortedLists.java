package org.example.linkedlist;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        lists[2] = new ListNode(2, new ListNode(6, null));
        ListNode result = solution.mergeKLists(lists);
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

        class Status implements Comparable<Status> {

            int val;
            ListNode pointer;

            Status(int val, ListNode pointer) {
                this.val = val;
                this.pointer = pointer;
            }

            @Override
            public int compareTo(Status o) {
                return this.val - o.val;
            }
        }

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            PriorityQueue<Status> queue = new PriorityQueue<>();
            ListNode head = new ListNode(0, null);
            ListNode pointer = head;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    queue.offer(new Status(lists[i].val, lists[i]));
                }
            }
            while (!queue.isEmpty()) {
                Status status = queue.poll();
                pointer.next = status.pointer;
                pointer = pointer.next;
                if (status.pointer.next != null) {
                    queue.offer(new Status(status.pointer.next.val, status.pointer.next));
                }
            }
            return head.next;
        }
    }
}
