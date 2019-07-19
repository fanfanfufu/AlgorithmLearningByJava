package com.fuqi.linkedlistlearn;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/7/19 10:59
 * @Version V1.0
 */
public class CycleLinkedList {
    private static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){ val = x; }
    }

    /**
     * 方法一：哈希表
     * 时间复杂度O(n)；空间复杂度O(n)
     * @param head
     * @return ListNode
     */
    public ListNode detectCycle1(ListNode head){
        if (head == null || head.next == null){ return null; }

        Set<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (visited.contains(cur)){
                return cur;
            }
            visited.add(cur);
            cur = cur.next;
        }

        return null;
    }

    /**
     * 方法二：floyd法
     * 时间复杂度O(n)；空间复杂度O(1)
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head){
        if (head == null || head.next == null){ return null; }

        ListNode slow = head;
        ListNode fast = head;

        ListNode meetpoint = null;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                meetpoint = slow;
                break;
            }
        }
        if (meetpoint == null){ return null; }

        ListNode cur = head;
        while (cur != meetpoint){
            cur = cur.next;
            meetpoint = meetpoint.next;
        }

        return cur;
    }
}
