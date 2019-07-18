package com.fuqi.linkedlistlearn;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/7/18 9:28
 * @Version V1.0
 */
public class OddEvenListTest {
    private static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){ val = x; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
