package com.fuqi.linkedlistlearn;

/**
 * @Description: 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为 2 -> 1 -> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是 1 -> 3
 * linkedList.get(1);            //返回3
 *
 * @Author: 傅琦
 * @DateTime: 2019/7/7 21:53
 * @Version: V1.0
 */
public class MyLinkedList {
    private class ListNode{
        int val;
        ListNode next = null;

        ListNode(int x){ val = x; }
    }

    /**
     * 链表的头指针
     */
    ListNode head;

    /**
     * 链表的长度
     */
    int size;

    /**
     * 构造方法
     */
    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }

    /**
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     */
    public int get(int index) {
        if (index > size || index < 1){ return -1; }

        ListNode cur = head;
        int count = 0;
        while (cur != null){
            if (count == index){
                return cur.val;
            }
            cur = cur.next;
            count++;
        }
        return -1;
    }

    /**
     * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     */
    public void addAtHead(int val) {
        ListNode first = new ListNode(val);
        first.next = head.next;
        head.next = first;
        size++;
    }

    /**
     * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
     */
    public void addAtTail(int val) {
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        size++;
    }

    /**
     * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
     */
    public void addAtIndex(int index, int val) {
        if (index < 1 || index > size){ return; }
        if (index == size){ addAtTail(val); }

        ListNode cur = head;
        int count = 0;
        while (cur != null){
            count++;
            if (count == index){
                ListNode node = new ListNode(val);
                node.next = cur.next;
                cur.next = node;
                size++;
                break;
            }
            cur = cur.next;
        }
    }

    /**
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     */
    public void deleteAtIndex(int index) {
        if (index < 1 || index > size){ return; }

        ListNode cur = head;
        int count = 0;
        while (cur != null){
            count++;
            if (count == index){
                cur.next = cur.next.next;
                size--;
                break;
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        int res1 = myLinkedList.get(1);
        System.out.println("res1 = " + res1);
        myLinkedList.deleteAtIndex(1);
        int res2 = myLinkedList.get(1);
        System.out.println("res2 = " + res2);
    }
}
