package com.fuqi.year2022.month01;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/1/11 22:30
 * @description 完美二叉树
 */
public class Solution00116 {
    /**
     * BFS
     *
     * @param root
     * @return
     */
    public Node connectBFS(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        Deque<Node> que = new LinkedList<>();
        root.next = null;
        que.offer(root);
        while (!que.isEmpty()) {
            Node curNode = que.poll();
            if (curNode.left == null && curNode.right == null) {
                continue;
            }
            // 左子节点的next指向右子节点
            curNode.left.next = curNode.right;
            // 右子节点的next需要判断curNode的next是否为空
            if (curNode.next == null) {
                // 若为空，则说明右子节点位最右边的节点，则next指向null
                curNode.right.next = null;
            } else {
                // 若不为空，则说明右子节点右边还有节点，即队列头节点的左子节点
                curNode.right.next = curNode.next.left;
            }
            que.offer(curNode.left);
            que.offer(curNode.right);
        }

        return root;
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public Node connectDFS(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
            connectDFS(root.left);
            connectDFS(root.right);
        }

        return root;
    }

    /**
     * 借助已建立的next关系
     *
     * @param root
     * @return
     */
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
                // 借助已经建立的next关系，实现同层的遍历
                cur = cur.next;
            }
            leftFirst = leftFirst.left;
        }

        return root;
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
