package com.fuqi.year2022.month10;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/10/8 22:03
 * @description
 */
public class Solution00024 {
    /**
     * 方法一：遍历写法
     * 
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            head = second.next;
            second.next = first;
            first.next = head;
            pre.next = second;
            pre = first;
        }
        
        return dummy.next;
    }

    /**
     * 方法二：递归写法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode curNext = head.next;
        // 递归成对翻转后面的节点，得到翻转后的头节点
        ListNode nextPairHead = swapPairs(curNext.next);
        // 进行交换，此处可以直接写为
        // head.next = swapPairs(curNext.next);
        head.next = nextPairHead;
        curNext.next = head;

        return curNext;
    }
}
