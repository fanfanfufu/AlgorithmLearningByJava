package com.fuqi.year2022.month01;

import com.fuqi.year2020.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FuQi
 * @date 2022/1/26 22:19
 * @description
 */
public class Solution00141 {
    /**
     * hash表法：
     * o(n)
     * o(n)
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (!visited.add(head)) {
                return true;
            }
            head = head.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
