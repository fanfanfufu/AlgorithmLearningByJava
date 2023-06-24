package com.fuqi.year2022.month06;

import com.fuqi.year2020.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/6/15 21:12
 * @description 重排链表
 */
public class Solution00143 {
    /**
     * 暴力解法：时间复杂度O(n^2)
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode cur = head;
        // 每次都要向后遍历一遍
        while (cur != null && cur.next != null) {
            ListNode pre = cur;
            ListNode tail = pre.next;
            while (tail.next != null) {
                tail = tail.next;
                pre = pre.next;
            }
            if (pre == cur) {
                break;
            }
            ListNode temp = cur.next;
            cur.next = tail;
            pre.next = null;
            tail.next = temp;
            cur = temp;
        }
    }

    /**
     * 分割+反转+重新拼接
     *
     * @param head
     */
    public void reorderList1(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head, slow = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode postHead = slow;
        if (fast == null) {
            // 偶数个节点时，fast会走到null
            pre.next = null;
        } else {
            // 奇数个节点时，fast节点会走到最后一个节点上
            // 此时需要翻转的部分是slow节点之后的部分
            postHead = slow.next;
            slow.next = null;
        }
        // 反转链表
        ListNode post = reverse(postHead);
        // 交错拼接
        ListNode cur1 = head, cur2 = post;
        while (cur1 != null && cur2 != null) {
            ListNode temp1 = cur1.next;
            ListNode temp2 = cur2.next;
            cur1.next = cur2;
            cur2.next = temp1;
            cur1 = temp1;
            cur2 = temp2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     *  现存储再拼接
     *
     * @param head
     */
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        // 拼接
        int i = 0, j = nodeList.size()-1;
        while (i < j) {
            nodeList.get(i).next = nodeList.get(j);
            i++;
            if (i == j) {
                break;
            }
            nodeList.get(j).next = nodeList.get(i);
            j--;
        }
        // 最后拼接上最后元素的next为空
        nodeList.get(i).next = null;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
//        four.next = five;
        Solution00143 solution00143 = new Solution00143();
        solution00143.reorderList1(one);
    }
}
