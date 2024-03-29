package com.fuqi.year2022.month01;

import com.fuqi.year2020.ListNode;

/**
 * @author FuQi
 * @date 2022/1/13 0:21
 * @description
 */
public class Solution00021 {
    /**
     * 采用递归的方式实现
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoListsDFS(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head;
        if (list1.val > list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }
        head.next = mergeTwoListsDFS(list1,list2);

        return head;
    }

    /**
     * 采用非递归的方式实现
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = new ListNode(1);
        ListNode cur = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
                continue;
            }
            if (list2 == null) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
                continue;
            }
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
                continue;
            }
            cur.next = list2;
            cur = cur.next;
            list2 = list2.next;
        }

        return head.next;
    }
}
