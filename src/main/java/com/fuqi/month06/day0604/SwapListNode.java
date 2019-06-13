package com.fuqi.month06.day0604;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/6/4 20:20
 * @Version V1.0
 */
public class SwapListNode {
    public static void main(String[] args){
        ListNode listNode = new ListNode(3);
        ListNode p = listNode;
        p.next = new ListNode(5);
        p = p.next;

        p.next = new ListNode(8);
        p = p.next;

        p.next = new ListNode(22);
        p = p.next;

        p.next = new ListNode(9);
        p = p.next;

        p.next = new ListNode(5);
        p = p.next;

        p.next = new ListNode(7);
        p = p.next;

        ListNode p2 = listNode;
        System.out.println("修改前：");
        while (p2 != null){
            System.out.print(p2.val + " ");
            p2 = p2.next;
        }
        System.out.println();

        ListNode res = swap(listNode, 3, 5);
        ListNode p3 = res;
        System.out.println("修改后：");
        while (p3 != null){
            System.out.print(p3.val + " ");
            p3 = p3.next;
        }
        System.out.println();

    }

    public static ListNode swap(ListNode head, int m, int n){
        // TODO CODE HERE
        if (head == null){ return null; }
        if (m == n){ return head; }

        ListNode cur1 = head;
        List<ListNode> nodes = new ArrayList<>();
        while (cur1 != null){
            nodes.add(cur1);
            cur1 = cur1.next;
        }

        ListNode reverse = new ListNode(0);
        ListNode reverse2 = reverse;
        for (int i = nodes.size() - 1; i >= 0 ; i--) {
            reverse2.next = new ListNode(nodes.get(i).val);
            reverse2 = reverse2.next;
        }
        reverse = reverse.next;

        int count = 1;
        ListNode cur2 = head;
        ListNode re3 = reverse;
        while (cur2 != null){
            if (count == Math.min(m, n) - 1){
                ListNode temp = cur2.next;
                cur2.next = re3.next;
                re3.next = temp;
            }
            if (count == Math.max(m, n)){
                ListNode temp = cur2.next;
                cur2.next = re3.next;
                re3.next = temp;
            }
            cur2 = cur2.next;
            re3 = re3.next;
            count++;
        }
        return head;
    }
}


class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }
}