package com.fuqi.linkedlistlearn;

import org.w3c.dom.ls.LSException;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/7/17 11:07
 * @Version V1.0
 */
public class RemoveListNodeTest {

    private static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {


        // 删除值相同的头结点后，可能新的头结点也值相等，用循环解决
        while (head != null && head.val == val){
            head = head.next;
        }
        if (head == null){return null;}

        ListNode cur = head;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(6);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);
        cur = cur.next;
        cur.next = new ListNode(6);

        RemoveListNodeTest listNodeTest = new RemoveListNodeTest();
        ListNode res = listNodeTest.removeElements(head, 6);

        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
