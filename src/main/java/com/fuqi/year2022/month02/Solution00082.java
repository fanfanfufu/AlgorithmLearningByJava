package com.fuqi.year2022.month02;

import com.fuqi.year2020.ListNode;

import java.util.*;

/**
 * @author FuQi
 * @date 2022/2/9 19:55
 * @description
 */
public class Solution00082 {
    public ListNode deleteDuplicates1(ListNode head) {
        Map<Integer, Integer> valueCountMap = new HashMap<>();
        for(ListNode cur = head; cur != null; cur = cur.next) {
            Integer valueCount = valueCountMap.getOrDefault(cur.val, 0) + 1;
            valueCountMap.put(cur.val, valueCount);
        }
        List<Integer> notRepeatValue = new ArrayList<>();
        for (Integer key : valueCountMap.keySet()) {
            if (valueCountMap.get(key) == 1) {
                notRepeatValue.add(key);
            }
        }
        if (notRepeatValue.isEmpty()) {
            return null;
        }
        Collections.sort(notRepeatValue);
        ListNode ans = new ListNode(notRepeatValue.get(0));
        ListNode cur = ans;
        for (int i = 1; i < notRepeatValue.size(); i++) {
            cur.next = new ListNode(notRepeatValue.get(i));
            cur = cur.next;
        }

        return ans;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode ans = pre;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (pre.next.val != cur.next.val) {
                // 没有重复节点时，指针往前走即可
                pre = pre.next;
                cur = cur.next;
                continue;
            }
            // 遇到重复值的节点时，cur指针往前走，知道cur.next != pre.next
            while (cur.next != null && cur.next.val == pre.next.val) {
                cur = cur.next;
            }
            // 将重复的部分删掉
//            pre.next = cur.next;
//            cur = pre.next;
            cur = cur.next;
            pre.next = cur;
        }

        return ans.next;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(-101);
        // pre勇于记录需要删除的重复值节点的前面的节点，方便删除玩重复的节点之后将链表再接上
        ListNode pre = dummyHead;
        pre.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        deleteDuplicates(head);
    }
}
