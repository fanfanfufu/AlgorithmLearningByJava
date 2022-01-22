package com.fuqi.year2022.month01;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/1/22 16:23
 * @description K个一组反转链表
 */
public class Solution00025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. 检查输入是否合理
        if (head == null){
            return null;
        }
        // 补充一个前置节点，便于每次取到链表中的k个一组的节点
        ListNode init = new ListNode(0);
        init.next= head;

        ListNode pre = init;
        ListNode end = init;

        while (end.next != null){
            // 遍历取k个节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) { break; }
            // 当前K个节点的头节点
            ListNode kstart = pre.next;
            // cur记录当前k个之后原链表上的第一个节点
            ListNode cur = end.next;
            // 将当前K个节点与主链断开
            end.next = null;
            // 翻转操作，并将翻转后的链表的头节点接在翻转前的头节点的上一个节点之后
            pre.next = reverse(kstart);
            // 翻转前的K个节点的头节点在翻转后已经位于尾部，
            // 此时，将cur所保存的主链的部分接到翻转后的链表之后
            kstart.next = cur;
            // 刷新pre，将下一组K个节点的头节点接在pre之后
            pre = kstart;
            // 刷新end指针
            end = pre;
        }

        return init.next;
    }

    /**
     * 链表的翻转操作
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverse2(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
