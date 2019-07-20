package com.fuqi.linkedlistlearn;

/**
 * @Description: 合并两个有序链表
 * @Author 傅琦
 * @date 2019/7/20 16:43
 * @Version V1.0
 */
public class MergeTwoLists {
    /**
     * 方法一：迭代
     * 时间复杂度O(m+n)，空间复杂度O(1)
     * @param l1
     * @param l2
     * @return ListNode
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = (l1 == null) ? l2 : l1;
        return preHead.next;
    }

    /**
     * 方法二：递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
