package com.fuqi.year2022.month12;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/12/8 21:33
 * @description
 */
public class Solution00061 {
    public ListNode rotateRight1(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            // 特殊入参判断
            return head;
        }
        // 1. 计数
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            len++;
        }
        // 2. 对k取模
        k %= len;
        if (k == 0) {
            return head;
        }
        // 3. 构造旋转后的链表
        ListNode cur = head;
        for (int i = 0; i < (len - k - 1); i++) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        ListNode newCur = newHead;
        while (newCur.next != null) {
            newCur = newCur.next;
        }
        newCur.next = head;

        return newHead;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - (k % n);
        if (add == n) {
            return head;
        }
        // 将链表构成环
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ans = iter.next;
        iter.next = null;

        return ans;
    }
}
