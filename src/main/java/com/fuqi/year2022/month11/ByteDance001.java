package com.fuqi.year2022.month11;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/11/20 22:29
 * @description
 */
public class ByteDance001 {
    public ListNode sortOddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1. 分割出奇偶链表
        ListNode oddHead = head;
        ListNode odd = oddHead;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        head = even.next;
        while (head != null && head.next != null) {
            odd.next = head;
            odd = odd.next;
            even.next = head.next;
            even = even.next;
            head = even.next;
        }
        // 将奇数链表的最后值为null
        odd.next = null;
        // 2. 反转偶数链表
        ListNode evenNew = reverseList(evenHead);
        // 3. 合并两个链表得到新的升序链表
        return mergeList(oddHead, evenNew);
    }

    private ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode newHead = reverseList(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        head.next = mergeList(list1, list2);

        return head;
    }
}
