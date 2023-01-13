package com.fuqi.year2023.month01;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2023/1/13 21:13
 * @description
 */
public class Offer52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }

        return curA;
    }
}
