package com.fuqi.day0519;

/**
 * @Description: 将两个链表各自拼接成一个整数，然后求两个整数的和，并且以倒叙链表的形式给出
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @Author 傅琦
 * @Date 2019/5/19 21:09
 * @Version V1.0
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode(0);
        ListNode p = l1, q = l2, current = sumList;
        int carray = 0;
        while (p != null || q!= null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carray;
            carray = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null){
                p = p.next;
            }

            if (q != null){
                q = q.next;
            }
        }

        if (carray > 0){
            current.next = new ListNode(carray);
        }
        return sumList.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
