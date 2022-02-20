package com.fuqi.year2022.month02.week281;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/2/20 10:56
 * @description
 */
public class Solution06013 {
    public ListNode mergeNodes(ListNode head) {
        ListNode left = head, right = head.next;
        // 1. 先将0之间的节点进行合并
        while (right != null) {
            int sum = 0;
            while (right.val != 0) {
                sum += right.val;
                right = right.next;
            }
            left.next = new ListNode(sum);
            left.next.next = right;
            left = right;
            right = right.next;
        }

        // 2. 去除除了第一个0节点以外的0节点
        left = head.next;
        right = left.next;
        while (right != null) {
            if (right.val == 0) {
                left.next = right.next;
                right = left.next;
            }
            if (right == null) {
                break;
            }
            left = left.next;
            right = right.next;
        }

        return head.next;
    }

    /**
     * 优化
     *
     * @param head
     * @return
     */
    public ListNode mergeNodes2(ListNode head) {
        ListNode left = head, right = left.next;
        // 1. 先将0之间的节点进行合并
        while (right != null) {
            int sum = 0;
            while (right.val != 0) {
                sum += right.val;
                right = right.next;
            }
            // 创建合并后的节点
            left.next = new ListNode(sum);
            // 将新节点放入原链表中
            left.next.next = right;
            // left节点往前移
            left = left.next;
            // 在原链表中去掉当前right指向的0系欸但
            left.next = right.next;
            // right指向left的next节点，然后进入下一次循环
            right = left.next;
        }

        return head.next;
    }
}
