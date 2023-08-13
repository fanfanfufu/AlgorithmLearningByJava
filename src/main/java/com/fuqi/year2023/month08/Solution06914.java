package com.fuqi.year2023.month08;

import com.fuqi.year2020.ListNode;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/13 10:40
 * @description
 */
public class Solution06914 {
    public ListNode doubleIt(ListNode head) {
        ListNode reversed = reverse(head);
        int carry = 0;
        ListNode carryNode = new ListNode(carry);
        ListNode cur = reversed;
        while (cur != null) {
            int curSum = 2 * cur.val + carry;
            ListNode node = new ListNode(curSum % 10);
            carry = curSum / 10;
            cur = cur.next;
            node.next = carryNode.next;
            carryNode.next = node;
        }
        if (carry == 1) {
            carryNode.val = 1;
            return carryNode;
        }

        return carryNode.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(9);
        Solution06914 solution06914 = new Solution06914();
        solution06914.doubleIt(head);
    }
}
