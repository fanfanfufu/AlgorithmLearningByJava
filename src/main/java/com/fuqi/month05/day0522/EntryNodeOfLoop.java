package com.fuqi.month05.day0522;

import java.util.ArrayList;

/**
 * @Description: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @Author 傅琦
 * @Date 2019/5/22 21:35
 * @Version V1.0
 */
public class EntryNodeOfLoop {
    public ListNode judgeLoop(ListNode pHead){
        if (pHead == null || pHead.next == null){
            return null;
        }

        ArrayList<ListNode> nodes = new ArrayList<>();
        while (pHead.next != null){
            if (nodes.contains(pHead)){
                return pHead;
            }
            nodes.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
}
