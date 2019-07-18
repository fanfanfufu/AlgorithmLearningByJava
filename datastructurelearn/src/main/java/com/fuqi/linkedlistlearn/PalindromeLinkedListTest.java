package com.fuqi.linkedlistlearn;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/7/18 11:03
 * @Version V1.0
 */
public class PalindromeLinkedListTest {

    private static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){ val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){ return true; }

        // 1. 复制+反转链表
        ListNode prev = null, cur = head;
        ListNode copy = new ListNode(head.val);
        ListNode cur2 = copy;
        while (cur != null){
            ListNode temp = cur.next;
            // 1. 复制操作
            if (temp != null){
                cur2.next = new ListNode(temp.val);
                cur2 = cur2.next;
            }
            // 2. 反转操作
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        // 2. 遍历两个链表，对比
        ListNode reverse = prev;
        while (copy != null){
            if (copy.val != reverse.val){
                return false;
            }
            copy = copy.next;
            reverse = reverse.next;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedListTest listTest = new PalindromeLinkedListTest();
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(1);
        cur.next.next = new ListNode(2);
        cur.next.next.next = new ListNode(1);
        boolean res = listTest.isPalindrome(head);
        System.out.println("res = " + res);
    }
}
