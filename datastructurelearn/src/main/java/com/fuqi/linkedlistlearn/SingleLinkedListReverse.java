package com.fuqi.linkedlistlearn;

/**
 * @Description: 单链表的反转，没有环的情况
 * @Author 傅琦
 * @date 2019/7/16 10:42
 * @Version V1.0
 */
public class SingleLinkedListReverse {

    private static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            val = x;
        }
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public ListNode reverse(ListNode head){
//        if (head == null){ return null; }
//        ListNode prev = null;
//        ListNode cur = head;
//        while (cur != null){
//            // 1. 取出当前节点在原链表中的下一个节点
//            ListNode temp = cur.next;
//            // 2. 将当前节点的下一个节点设置为其在原链表中的前一个节点
//            cur.next = prev;
//            // 3. 将当前节点赋值给其前一个节点的指针
//            prev = cur;
//            // 4. 将当前节点的下一个节点赋值
//            cur = temp;
//        }
//        return prev;
        if (head == null) { return head;}
        ListNode prev = null;
        ListNode cur = head;

        while(head != null) {
            // 一定要先执行head指针的移动
            head = head.next;
            cur.next = prev;
            prev = cur;
            cur = head;
        }

        return prev;
    }
}
