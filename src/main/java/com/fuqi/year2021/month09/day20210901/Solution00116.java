package com.fuqi.year2021.month09.day20210901;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 */
public class Solution00116 {
    /**
     * BFS
     * @param root
     * @return
     */
    public Node connectBFS1(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (queue.isEmpty()) {
                cur.next = null;
            }
            if (cur.right != null) {
                cur.left.next =cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                } else {
                    cur.right.next = null;
                }
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }

        return root;
    }

    public Node connectBFS2(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if (i != len-1) {
                    cur.next = queue.peek();
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        return root;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node leftFirst = root;
        while (leftFirst.left != null) {
            Node cur = leftFirst;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            leftFirst = leftFirst.left;
        }

        return root;
    }
}
