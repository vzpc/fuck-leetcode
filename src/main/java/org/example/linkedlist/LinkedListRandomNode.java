package org.example.linkedlist;

import java.util.Random;

public class LinkedListRandomNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        Solution solution = new Solution(head);
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }

    private static class Solution {

        private ListNode head;

        private Random random;

        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        public int getRandom() {
            int i = 1, result = 0;
            for (ListNode node = head; node != null; node = node.next) {
                if (random.nextInt(i) == 0) {
                    result = node.val;
                }
                ++i;
            }
            return result;
        }
    }
}
