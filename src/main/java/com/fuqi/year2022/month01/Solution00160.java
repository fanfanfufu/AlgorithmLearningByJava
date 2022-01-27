package com.fuqi.year2022.month01;

import com.fuqi.year2020.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FuQi
 * @date 2022/1/27 22:15
 * @description
 */
public class Solution00160 {
    /**
     * Hash表法
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            nodeSet.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (nodeSet.contains(temp)) {
                return temp;
            }
            nodeSet.add(temp);
            temp = temp.next;
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            // curA遍历完之后指向headB，从B的头节点开始遍历，知道最终遍历到B的尾部为null的地方
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }

        return curA;
    }
}
