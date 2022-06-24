package com.fuqi.year2022.month06;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/6/24 22:04
 * @description 链表排序
 */
public class Solution00148 {
    /**
     * 使用归并排序，
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针将链表一分为二
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // tmp就是后半截链表的头节点
        ListNode tmp = slow.next;
        slow.next = null;
        // 对左右两半的链表递归排序
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;

        return res.next;
    }
}
