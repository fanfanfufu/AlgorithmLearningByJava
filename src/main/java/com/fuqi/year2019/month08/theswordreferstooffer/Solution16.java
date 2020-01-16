package com.fuqi.year2019.month08.theswordreferstooffer;

/**
 * @Description: 合并两个排序的链表
 * @Author 傅琦
 * @date 2019/8/9 10:43
 * @Version V1.0
 */
public class Solution16 {
    /**
     * 递归解法
     * @param list1 链表1
     * @param list2 链表2
     * @return ListNode
     */
    public ListNode merge(ListNode list1,ListNode list2){
        if (list1 == null){
            return list2;
        }

        if (list2 == null){
            return list1;
        }

        if (list1.val <= list2.val){
            list1.next = merge(list1.next, list2);
            return list1;
        }else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }

    /**
     * 非递归解法
     * @param list1 链表1
     * @param list2 链表2
     * @return ListNode
     */
    public ListNode merge2(ListNode list1, ListNode list2){
        ListNode ans = new ListNode(0);
        ListNode cur = ans;

        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null){
            cur.next = list1;
        }

        if (list2 != null){
            cur.next = list2;
        }

        return ans.next;
    }
}
