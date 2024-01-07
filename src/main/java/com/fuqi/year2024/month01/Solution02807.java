package com.fuqi.year2024.month01;

import com.fuqi.year2020.ListNode;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/1/6 21:42
 * @description
 */
public class Solution02807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            ListNode waitAdd = new ListNode(gcd(cur.val, next.val));
            cur.next = waitAdd;
            waitAdd.next = next;
            cur = next;
        }

        return head;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
