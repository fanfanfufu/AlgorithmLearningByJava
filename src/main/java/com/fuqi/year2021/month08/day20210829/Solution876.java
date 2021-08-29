package com.fuqi.year2021.month08.day20210829;

import com.fuqi.year2020.ListNode;

/**
 * 链表的中间结点
 * @author FuQi
 */
public class Solution876 {
    public static ListNode middleNode(ListNode head) {
        int length = 0;
        for(ListNode cur = head; cur != null; cur = cur.next){
            length++;
        }
        int mid = (length / 2);
        ListNode ans = head;
        for(int i = 0; i < mid; i++){
            ans = ans.next;
        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        ListNode listNode = middleNode(head);
        System.out.println("listNode = " + listNode.val);
    }
}
