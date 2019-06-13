package com.fuqi.month05.day0520;

/**
 * @Description:
 * @Team 电子科技大学自动化研究所
 * @Author 傅琦
 * @Date 2019/5/20 18:51
 * @Version V1.0
 */
public class MyThead extends Thread{
    public static void main(String[] args) {
        MyThead t=new MyThead();
        MyThead s=new MyThead();
        t.start();
        System.out.println("one.");
        s.start();
        System.out.println("two.");
    }
    public void run() {
        System.out.println("Thread");
    }
}
