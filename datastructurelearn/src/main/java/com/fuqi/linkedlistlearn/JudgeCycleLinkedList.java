package com.fuqi.linkedlistlearn;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/7/19 9:44
 * @Version V1.0
 */
public class JudgeCycleLinkedList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x){
            val = x;
        }
    }

    /**
     * 方法一：哈希表
     * 时间复杂度O(n); 空间复杂度O(n)
     * @param head
     * @return boolean
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null){ return false; }

        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null){
            if (nodeSet.contains(head)){
                return true;
            }else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 方法二：双指针法
     * 时间复杂度O(n), 空间复杂度O(1)
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null){ return false; }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
