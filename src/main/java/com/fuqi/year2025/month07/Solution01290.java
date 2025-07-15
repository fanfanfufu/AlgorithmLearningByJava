package com.fuqi.year2025.month07;

import com.fuqi.year2020.ListNode;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2025/7/14 23:25
 * @description
 */
public class Solution01290 {
    public int getDecimalValue(ListNode head) {
        ListNode cur = head;    // 定义一个指针指向头节点
        int ans = 0;    // 定义一个变量来存储结果
        // 遍历链表，将每个节点的值乘以2的幂次方，加到结果中
        // 例如：1->0->1->0->1->0    1*2^5 + 0*2^4 + 1*2^3 + 0*2^2 + 1*2^1 + 0*2^0 = 42
        while (cur != null) {
            ans = ans * 2 + cur.val;
            cur = cur.next;
        }
        return ans;
    }
}
