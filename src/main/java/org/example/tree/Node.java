package org.example.tree;

public class Node {

    int val;
    Node left;
    Node right;
    Node next;

    Node() {
    }

    Node(int _val) {
        val = _val;
    }

    Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
