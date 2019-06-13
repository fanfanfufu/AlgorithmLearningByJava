package com.fuqi.month05.day0523;

import java.util.ArrayList;

/**
 * @Description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Author 傅琦
 * @Date 2019/5/23 9:19
 * @Version V1.0
 */
public class DeleteDuplicationListNode {

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        ListNode node1 = node;

        node1.next = new ListNode(2);
        node1 = node1.next;

        node1.next = new ListNode(3);
        node1 = node1.next;

        node1.next = new ListNode(3);
        node1 = node1.next;

        node1.next = new ListNode(4);
        node1 = node1.next;

        node1.next = new ListNode(4);
        node1 = node1.next;

        node1.next = new ListNode(5);
        node1 = node1.next;

//        while (node != null){
//            System.out.print(node.val + " ");
//            node = node.next;
//        }

        System.out.println();
        System.out.println("========================================");

        DeleteDuplicationListNode ddnode = new DeleteDuplicationListNode();
        ListNode result = ddnode.deleteDuplication(node);
        if (result == null){
            System.out.println("null");
        }

        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    /**
     * 计算超时
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication1(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return pHead;
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        while (pHead != null){
            if ((!list1.contains(pHead.val)) && (!list2.contains(pHead.val))){
                list1.add(pHead.val);
                pHead = pHead.next;
            }else if ((list1.contains(pHead.val)) && (!list2.contains(pHead.val))){
                list2.add(pHead.val);
                pHead = pHead.next;
            }
        }

        ListNode node = new ListNode(0);
        ListNode node1 = node;
        for (int value: list1) {
            if (!list2.contains(value)){
                node1.next = new ListNode(value);
                node1 = node1.next;
            }
        }

        return node.next;
    }

    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode cur;

        if (pHead.val == pHead.next.val){
            cur = pHead.next.next;
            while (cur != null && cur.val == pHead.val){
                cur = cur.next;
            }

            return deleteDuplication(cur);
        }

        cur = pHead.next;
        pHead.next = deleteDuplication(cur);
        return pHead;
    }
}

class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
}

