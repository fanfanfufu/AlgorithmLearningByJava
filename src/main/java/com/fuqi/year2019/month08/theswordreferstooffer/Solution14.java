package com.fuqi.year2019.month08.theswordreferstooffer;

/**
 * @Description: 链表中的倒数第k个节点
 * @Author 傅琦
 * @date 2019/8/9 9:50
 * @Version V1.0
 */
public class Solution14 {
    /**
     * 方法一：先遍历一遍链表，记录链表的长度，然后在从头开始走 length-K步获取倒数第K个节点
     * @param head 链表头节点
     * @param k 倒数的位置
     * @return ListNode
     */
    public ListNode findKthToTail1(ListNode head, int k){
        if (head == null || k == 0){
            return null;
        }
        ListNode cur1 = head;
        int length = 1;
        while (cur1.next != null){
            cur1 = cur1.next;
            length++;
        }

        if (k <= length){
            for (int i = 1; i <= length-k; i++) {
                head = head.next;
            }
        }else {
            return null;
        }

        return head;
    }

    /**
     * 方法二：双指针法。第一个指针走K-1步，达到顺数的第K个节点，
     * 第二个指针再从第一个节点开始走，
     * 两个指针同时走，直到第一个指针走到最后一个节点上，返回第二个指针上的节点即可
     * @param head 链表头节点
     * @param k 倒数的位置
     * @return ListNode
     */
    public ListNode findKthToTail2(ListNode head, int k){
        if (head == null || k == 0){
            return null;
        }

        ListNode cur1 = head;
        for (int i = 1; i < k && cur1 != null; i++) {
            cur1 = cur1.next;
        }

        if (cur1 == null){
            return null;
        }

        ListNode cur2 = head;
        while (cur1.next != null){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur2;
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
        cur = cur.next;
        cur.next = new ListNode(7);
        cur = cur.next;
        cur.next = new ListNode(8);
        cur = cur.next;
        cur.next = new ListNode(9);

        Solution14 solution14 = new Solution14();
        ListNode res = solution14.findKthToTail2(head, 4);
        System.out.println("res = " + res.val);
    }
}
