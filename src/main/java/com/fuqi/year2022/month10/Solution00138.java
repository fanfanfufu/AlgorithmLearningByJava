package com.fuqi.year2022.month10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FuQi
 * @date 2022/10/11 23:25
 * @description
 */
public class Solution00138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // map存放当前节点复制创建的新节点
    private Map<Node, Node> cacheNode = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cacheNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cacheNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }

        return cacheNode.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    /**
     * O(1)时间复杂度
     *
     * @param head
     * @return
     */
    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node= node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }

        for (Node node = head; node != null; node= node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = node.random == null ? null : node.random.next;
        }

        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = nodeNew.next == null ? null : nodeNew.next.next;
        }

        return headNew;
    }

    /**
     * O(1)时间复杂度只遍历两次，没过，需要再看看
     *
     * @param head
     * @return
     */
    public Node copyRandomList4(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node= node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            nodeNew.random = node.random == null ? null : node.random.next;
            node.next = node.next.next;
            nodeNew.next = nodeNew.next == null ? null : nodeNew.next.next;
        }

        return headNew;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        String s = map.get(null);
        System.out.println(s);
    }
}
