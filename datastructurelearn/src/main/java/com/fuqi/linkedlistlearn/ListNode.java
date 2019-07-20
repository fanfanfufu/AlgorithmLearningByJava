package com.fuqi.linkedlistlearn;

/**
 * @Description: 一个单链表，便于其他类使用
 * @Author 傅琦
 * @date 2019/7/20 15:29
 * @Version V1.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x){
        val = x;
        next = null;
    }
}
