package com.fuqi.year2023.month08;

import com.fuqi.year2020.ListNode;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/5 22:39
 * @description
 */
public class Solution06940 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode left = head, right = left.next;
        while (right != null) {
            int small = Math.min(left.val, right.val);
            int big = Math.max(left.val, right.val);
            // 求最大公约数
            // 先判断较大值是否能被较小值整除，能的话则说明最大公约数就是较小值，否则需要使用辗转相除法求
            int maxCommon = big % small == 0 ? small : gcd(small, big);
            left.next = new ListNode(maxCommon);
            left.next.next = right;
            left = right;
            right = right.next;
        }
        return head;
    }

    /**
     * 辗转相除法求最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public static void main(String[] args) {
        Solution06940 solution06940 = new Solution06940();
        System.out.println(solution06940.gcd(18, 6));
    }
}
