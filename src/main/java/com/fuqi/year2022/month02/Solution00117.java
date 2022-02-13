package com.fuqi.year2022.month02;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/2/13 18:42
 * @description
 */
public class Solution00117 {
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        // BFS
        bfs(root);

        return root;
    }

    private void bfs(Node root) {
        Deque<Node> nodeDeque = new LinkedList<>();
        nodeDeque.offerLast(root);
        while (!nodeDeque.isEmpty()) {
            int layerLen = nodeDeque.size();
            for (int i = 0; i < layerLen; i++) {
                Node cur = nodeDeque.pollFirst();
                if (i == layerLen-1) {
                    cur.next = null;
                } else {
                    cur.next = nodeDeque.peekFirst();
                }
                if (cur.left != null) {
                    nodeDeque.offerLast(cur.left);
                }
                if (cur.right != null) {
                    nodeDeque.offerLast(cur.right);
                }
            }
        }
    }

    private Node last = null, nextLayerStart = null;

    /**
     * 借助已建立的next 关系，按层处理
     *
     * @param root
     * @return
     */
    private Node connect2(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        Node start = root;
        while (start != null) {
            last = null;
            nextLayerStart = null;
            Node cur = start;
            while (cur != null) {
                if (cur.left != null) {
                    handle(cur.left);
                }
                if (cur.right != null) {
                    handle(cur.right);
                }
                cur = cur.next;
            }
            start = nextLayerStart;
        }

        return root;
    }

    private void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextLayerStart == null) {
            nextLayerStart = p;
        }
        last = p;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node6.right = node8;
        node4.left = node7;
        node3.right = node6;
        node2.left = node4;
        node2.right = node5;
        node1.left = node2;
        node1.right = node3;
        Solution00117 solution00117 = new Solution00117();
        solution00117.connect(node1);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}