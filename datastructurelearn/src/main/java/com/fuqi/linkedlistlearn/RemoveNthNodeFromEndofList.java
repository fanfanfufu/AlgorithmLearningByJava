package com.fuqi.linkedlistlearn;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/7/20 15:29
 * @Version V1.0
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){ return null; }

        ListNode dumy = new ListNode(0);
        dumy.next = head;
        int len = 0;
        ListNode first = head;
        while (first != null){
            len++;
            first = first.next;
        }

        if (n > len || n < 0){ return head; }
        if (n == len){ return head.next; }
        len -= n;
        first = dumy;
        while (len > 0){
            len--;
            first = first.next;
        }
        first.next = first.next.next;
        return dumy.next;
    }
}
