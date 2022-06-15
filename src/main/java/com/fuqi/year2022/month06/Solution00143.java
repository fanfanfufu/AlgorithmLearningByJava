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
    public void reorderList(ListNode head) {
        ListNode cur = head;
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
            pre.next = null;
        } else {
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
        nodeList.get(i).next = null;
    }

    public void reorderList3(ListNode head) {

    }
}
