package com.fuqi.year2024.month01;

import com.fuqi.year2020.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/1/3 21:41
 * @description
 */
public class Solution02487 {
    public ListNode removeNodes1(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        for (; head != null; head = head.next) {
            stack.offerFirst(head);
        }
        while (!stack.isEmpty()) {
            if (head == null) {
                stack.peekFirst().next = head;
                head = stack.pollFirst();
                continue;
            }
            // 栈顶节点的值小于右边节点的值，需要出栈并且不接入新链表
            if (stack.peekFirst().val < head.val) {
                stack.pollFirst();
                continue;
            }
            // 站定节点的值大于等于右边节点的值，则拼接进入新链表
            stack.peekFirst().next = head;
            head = stack.pollFirst();
        }

        return head;
    }


    /**
     * 先反转链表，再从左往右遍历，然后删除值小于当前节点的下一个节点，最后再反转回来
     *
     * @param head
     * @return
     */
    public ListNode removeNodes2(ListNode head) {
        if (head == null || head.next == null) return head;
        head = reverse1(head);
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val > cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return reverse2(head);
    }

    private ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (head != null) {
            head = head.next;
            cur.next = pre;
            pre = cur;
            cur = head;
        }

        return pre;
    }

    private ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverse2(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
