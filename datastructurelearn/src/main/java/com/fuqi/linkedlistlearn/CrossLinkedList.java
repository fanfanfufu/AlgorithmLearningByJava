package com.fuqi.linkedlistlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 相交链表
 * @Author 傅琦
 * @date 2019/7/20 10:46
 * @Version V1.0
 */
public class CrossLinkedList {

    private static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            val = x;
            next = null;
        }
    }

    /**
     * 方法一：哈希表
     * 时间复杂度O(m+n)，空间复杂度O(m+n)
     * @param headA
     * @param headB
     * @return ListNode
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) { return null; }
        ListNode curA = headA;
        ListNode curB = headB;

        // 遍历两个链表，将各自的节点分别添加到各自的集合中保存
        List<ListNode> listA = new ArrayList<>();
        List<ListNode> listB = new ArrayList<>();
        while (curA != null || curB != null){
            if (curA != null){
                listA.add(curA);
                curA = curA.next;
            }
            if (curB != null){
                listB.add(curB);
                curB = curB.next;
            }
        }

        // 再遍历其中一个链表，判断其中出现在另一个集合中的第一个元素
        for (ListNode node : listA) {
            if (listB.contains(node)){
                return node;
            }
        }
        // 若没有，则返回null
        return null;
    }

    /**
     * 暴力解法
     * 时间复杂度O(m+n)，空间复杂度O(1)
     * @param headA
     * @param headB
     * @return ListNode
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if (headA == null || headB == null) { return null; }

        while (headA != null){
            ListNode cur = headB;
            while (cur != null){
                if (headA == cur){
                    return cur;
                }
                cur = cur.next;
            }
            headA = headA.next;
        }
        return null;
    }

    /**
     * 方法三：时间复杂度O(n), 空间复杂度O(1)
     * @param headA
     * @param headB
     * @return ListNode
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) { return null; }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
