package com.fuqi.year2022.month05;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/6/1 22:47
 * @description
 */
public class Solution00142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }
}
