package com.fuqi.linkedlistlearn;

/**
 * @author FuQi
 * @date 2021/06/07
 * @desc 遍历并打印单链表
 */
public class PrintListNoe {
    public static void main(String[] args) {
        // 1. 循环创建一个单链表
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int listNodeLength = 32;
        for (int i = 1; i < listNodeLength; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        // 遍历并打印出其节点的内容
        for (ListNode temp = head.next; temp != null ; temp=temp.next) {
            if (temp.next == null) {
                System.out.print(temp.val);
                continue;
            }
            System.out.print(temp.val + "->");
        }
    }
}
