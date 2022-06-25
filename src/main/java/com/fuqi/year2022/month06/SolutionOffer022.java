package com.fuqi.year2022.month06;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/6/25 14:55
 * @description 剑指 Offer 22. 链表中倒数第k个节点
 */
public class SolutionOffer022 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            tail = tail.next;
        }
        while (tail != null) {
            tail = tail.next;
            ans = ans.next;
        }

        return ans.next;
    }
}
