package com.fuqi.year2021.month08.day20210829;

import com.fuqi.year2020.ListNode;

/**
 * 删除链表的倒数第N个节点
 * @author FuQi
 */
public class Solution00019 {
    /**
     * 采用快慢指针，即可实现遍历一次就能删除目标节点
     *
     * @param head
     * @param n
     * @return
     */
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

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head;
        int i = 0;
        while (i < n && fast.next != null) {
            fast = fast.next;
            i++;
        }
        if (i < n) {
            // 说明n=链表长度，即删除第一个节点
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            tail = tail.next;
        }
        ListNode pre = dummy;
        // 这里不需要判断tail是否为空是因为输入的n最大为链表本来的长度，因为最前面补充了一个dummy节点
        // 结果遍历后tail一定不会为空
        while (tail.next != null) {
            tail = tail.next;
            pre = pre.next;
        }
        // 执行删除操作
        pre.next = pre.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        removeNthFromEnd2(head, 1);
    }
}
