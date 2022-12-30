package com.fuqi.year2022.month12;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/12/30 21:22
 * @description
 */
public class Solution00445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 先反转两个链表
        ListNode reverseL1 = reverse(l1);
        ListNode reverseL2 = reverse(l2);
        int carry = 0;
        ListNode sum = new ListNode(0);
        ListNode cur = sum;
        // 在进行相加运算
        while (reverseL1 != null || reverseL2 != null) {
            int x = reverseL1 == null ? 0 : reverseL1.val;
            int y = reverseL2 == null ? 0 : reverseL2.val;
            int z = x + y + carry;
            cur.next = new ListNode(z % 10);
            carry = z / 10;
            cur = cur.next;
            if (reverseL1 != null) reverseL1 = reverseL1.next;
            if (reverseL2 != null) reverseL2 = reverseL2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        // 最后再反转
        return reverse(sum.next);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next= head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        Solution00445 solution00445 = new Solution00445();
        System.out.println(solution00445.addTwoNumbers(l1, l2));
    }
}
