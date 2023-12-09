package org.example.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, DLinkedNode> keyMap;

    private DLinkedNode head;

    private DLinkedNode tail;

    private int capacity;

    private int size;

    public LRUCache(int capacity) {
        this.keyMap = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (this.keyMap.containsKey(key)) {
            DLinkedNode listNode = this.keyMap.get(key);
            this.moveToHead(listNode);
            return listNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (this.keyMap.containsKey(key)) {
            DLinkedNode linkedNode = this.keyMap.get(key);
            linkedNode.value = value;
            this.moveToHead(linkedNode);
        } else {
            DLinkedNode listNode = new DLinkedNode(key, value);
            if (this.size == this.capacity) {
                DLinkedNode node = this.tail.prev;
                this.remoteNode(node);
                this.keyMap.remove(node.key);
                this.addToHead(listNode);
            } else {
                this.addToHead(listNode);
                this.size++;
            }
            this.keyMap.put(key, listNode);
        }
    }

    private void remoteNode(DLinkedNode listNode) {
        listNode.prev.next = listNode.next;
        listNode.next.prev = listNode.prev;
    }

    private void addToHead(DLinkedNode listNode) {
        listNode.prev = this.head;
        listNode.next = this.head.next;
        this.head.next.prev = listNode;
        this.head.next = listNode;
    }

    private void moveToHead(DLinkedNode listNode) {
        this.remoteNode(listNode);
        this.addToHead(listNode);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
