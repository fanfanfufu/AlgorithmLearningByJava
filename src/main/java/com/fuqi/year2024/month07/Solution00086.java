package com.fuqi.year2024.month07;

import com.fuqi.year2020.ListNode;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/7/15 22:25
 * @description
 */
public class Solution00086 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode bigHead = new ListNode(0);
        ListNode big = bigHead;
        ListNode cur = head;
        while (cur != null) {
            int curVal = cur.val;
            if (curVal < x) {
                small.next = cur;
                small = small.next;
            } else {
                big.next = cur;
                big = big.next;
            }
            cur = cur.next;
        }
        big.next = null;
        small.next = bigHead.next;

        return smallHead.next;
    }
}
