package com.fuqi.year2023.month04;

import com.fuqi.year2020.ListNode;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/24 21:44
 * @description 删除制定的节点（给定的输入不是最后一个节点）
 */
public class Solution00237 {
    public void deleteNode(ListNode node) {
        // 1. 将node节点的下一个节点的值复制给node
        node.val = node.next.val;
        // 2. 删除node的下一个节点
        node.next = node.next.next;
    }
}
