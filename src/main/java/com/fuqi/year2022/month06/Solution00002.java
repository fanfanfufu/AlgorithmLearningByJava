package com.fuqi.year2022.month06;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/6/24 22:40
 * @description
 */
public class Solution00002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        int add = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + add;
            add = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (add > 0) {
            cur.next = new ListNode(add);
        }

        return ans.next;
    }

    public static void main(String[] args) {
        System.out.println('2'-'0');
    }
}
