package com.fuqi.year2021.month08.day20210829;

import com.fuqi.year2020.ListNode;

/**
 * 删除链表的倒数第N个节点
 * @author FuQi
 */
public class Solution00019 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode first = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        ListNode second = pre;
        while (first !=null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        removeNthFromEnd(head, 1);
    }
}
