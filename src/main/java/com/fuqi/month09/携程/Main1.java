package com.fuqi.month09.携程;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main1 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head, int m) {
        if (head == null || head.next == null) { return head; }

        ListNode head1 = new ListNode(m);
        ListNode head2 = new ListNode(m);
        ListNode pre = head1;
        ListNode after = head2;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val > m) {
                after.next = cur;
                after = after.next;
            } else {
                pre.next = cur;
                pre = pre.next;
            }
        }

        if (head1.next == null) {
            return head;
        } else {
            pre.next = head2.next;
            after.next = null;
            return head1.next;
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}

