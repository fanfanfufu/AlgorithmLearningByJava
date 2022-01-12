package com.fuqi.year2022.month01;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/1/13 0:24
 * @description 206题：反转链表
 */
public class Solution00206 {
    /**
     * 使用遍历的方式做
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(0);
        ListNode cur = head;

        while (head != null) {
            head = head.next;
            cur.next = pre;
            pre = cur;
            cur = head;
        }

        return pre.next;
    }

    /**
     * 递归写法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // newHead就是head.next
        ListNode newHead = reverseList(head.next);
        // 进行反转操作：
        // 例如之前的指针指向是：3 -> 4
        head.next.next = head;
        // 经过反转后：3 <-> 4
        head.next = null;
        // 在处理后：null <- 3 <- 4
        return newHead;
    }
}
