package org.example.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.random = null;
        head.next.next = new Node(11);
        head.next.random = head;
        head.next.next.next = new Node(10);
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.next = new Node(1);
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        Node result = solution.copyRandomList(head);
        if (result != null) {
            while (true) {
                System.out.print(result.val + ",");
                if (result.next != null) {
                    result = result.next;
                } else {
                    break;
                }
            }
        }
    }

    private static class Solution {

        private Map<Node, Node> cachedNodeMap = new HashMap<>();

        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            if (cachedNodeMap.containsKey(head)) {
                return cachedNodeMap.get(head);
            }
            Node node = new Node(head.val);
            cachedNodeMap.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
            return node;
        }
    }
}
