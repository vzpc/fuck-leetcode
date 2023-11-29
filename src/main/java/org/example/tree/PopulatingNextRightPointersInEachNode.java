package org.example.tree;

import java.util.Deque;
import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        Node root = new Node(1, new Node(2), new Node(3), null);
        Node result = solution.connect(root);
        while (result != null) {
            Node temp = result;
            while (temp != null) {
                System.out.print(temp.val + ",");
                temp = temp.next;
            }
            System.out.println();
            result = result.left;
        }
    }

    private static class Solution {

        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Deque<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Node pre = null;
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    if (pre != null) {
                        pre.next = node;
                    }
                    pre = node;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return root;
        }
    }
}
