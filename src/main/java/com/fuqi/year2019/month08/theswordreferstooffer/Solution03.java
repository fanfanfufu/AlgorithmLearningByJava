package com.fuqi.year2019.month08.theswordreferstooffer;

import java.util.ArrayList;

/**
 * @Description: 从尾到头打印链表
 * @Author 傅琦
 * @date 2019/8/7 10:03
 * @Version V1.0
 */
public class Solution03 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null){
            return list;
        }

        ListNode reverse = reverseListNode(listNode);
        for (ListNode cur = reverse; cur != null; cur = cur.next) {
            list.add(cur.val);
        }
        return list;
    }

    private ListNode reverseListNode(ListNode listNode){
        if (listNode == null || listNode.next == null){
            return listNode;
        }

        ListNode pre = null;
        ListNode cur = listNode;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
