package com.fuqi.year2022.month05;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/5/24 22:46
 * @description
 */
public class Solution00092 {
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode leftPre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
        }

        ListNode rightNode = leftPre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = leftPre.next;
        // 右边界的下一个节点
        ListNode rightNext = rightNode.next;

        // 截断
        leftPre.next = null;
        rightNode.next = null;

        reverseLinkedList(leftNode);

        leftPre.next = rightNode;
        leftNode.next = rightNext;

        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
    }

    /**
     * 头插法，一定要注意翻转的几个步骤的执行顺序
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = dummyNode;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;

        for (int i = 0; i < right - left; i++) {
            // 1. 保存当前需要翻转的节点
            ListNode temp = cur.next;
            // 2. 先建立翻转后尾部节点与整个链表后续节点的连接
            cur.next = temp.next;
            // 3. 建立reverse节点的next关系
            temp.next = pre.next;
            // 4. 接回整个链表
            pre.next = temp;
        }

        return dummyNode.next;
    }
}
