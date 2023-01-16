package com.fuqi.year2023.month01;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author FuQi
 * @date 2023/1/16 21:29
 * @description
 */
public class LRUCache {
    /**
     * 先定义一个双向链表
     */
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

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        if (capacity < 1) throw new RuntimeException("不能实例化一个容量为0的cache对象");
        this.capacity = capacity;
        this.size = 0;
        // 构造虚拟头尾节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = this.cache.get(key);
        if (Objects.isNull(node)) return -1;
        // 因为被获取过，所以要将该节点放到头部
        moveToHead(node);

        return node.value;
    }

    private void moveToHead(DLinkedNode node) {
        // 先移除该节点
        removeNode(node);
        // 再添加节点到头部
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node) {
        node.prev = this.head;
        node.next = this.head.next;

        this.head.next.prev = node;
        this.head.next = node;
    }

    public void put(int key, int value) {
        DLinkedNode node = this.cache.get(key);
        if (Objects.nonNull(node)) {
            node.value = value;
            moveToHead(node);
            return;
        }
        DLinkedNode newNode = new DLinkedNode(key, value);
        this.cache.put(key, newNode);
        addToHead(newNode);
        this.size++;
        if (this.size > this.capacity) {
            DLinkedNode tail = removeTail();
            this.cache.remove(tail.key);
            this.size--;
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode prev = this.tail.prev;
        removeNode(prev);

        return prev;
    }
}
