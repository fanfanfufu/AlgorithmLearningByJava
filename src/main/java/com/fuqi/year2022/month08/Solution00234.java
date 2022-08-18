package com.fuqi.year2022.month08;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/8/14 22:44
 * @description  回文链表
 */
public class Solution00234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode pre = null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            ListNode tmp = slow.next;
            if (pre != null) {
                slow.next = pre;
            }
            pre = slow;
            slow = tmp;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        while (slow != null) {
            if (slow.val != pre.val) return false;
            slow = slow.next;
            pre = pre.next;
        }

        return true;
    }
}
