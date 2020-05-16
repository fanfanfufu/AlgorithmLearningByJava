package com.fuqi.year2020.month05.day16;

import com.fuqi.year2020.ListNode;

/**
 * @Description: 链表翻转(每K个一组翻转，最后不够的不用翻转)
 * @Author: 傅琦
 * @DateTime: 2020/5/16 10:23
 * @Version: V1.0
 */
public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. 检查输入是否合理
        if (head == null){ return head; }
        ListNode init = new ListNode(0);
        init.next= head;

        ListNode pre = init;
        ListNode end = init;

        while (end.next != null){
            for (int i = 0; i < k && end != null; i++) { end = end.next; }
            if (end == null) { break; }
            // 当前K个节点的头节点
            ListNode kstart = pre.next;
            // cur记录当前k个之后链上的第一个节点
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
        ListNode preNode = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = temp;
        }
        return preNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);
        cur = cur.next;
        cur.next = new ListNode(6);

        LeetCode25 leetCode25 = new LeetCode25();
        ListNode res = leetCode25.reverseKGroup(head, 3);
        while (res != null){
            System.out.print(res.val + ", ");
            res = res.next;
        }
    }
}
