package com.fuqi.year2023.month02;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2023/2/7 22:35
 * @description
 */
public class Solution00141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }

        return false;
    }
}
