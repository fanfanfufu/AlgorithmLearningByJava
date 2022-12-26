package com.fuqi.year2022.month12;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/12/26 22:26
 * @description 奇偶链表
 */
public class Solution00328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = odd.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}
