package com.fuqi.queuelearn;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description: 队列学习
 * @Author 傅琦
 * @Date 2019/5/25 20:50
 * @Version V1.0
 */
public class QueueLearning {

    public static void main(String[] args){
        Queue<Integer> queue = new ArrayBlockingQueue<>(5);
        System.out.println("the init queue: "+ queue);
        // 在队列为空时调用remove方法，会有NoSuchElementException异常抛出
//        queue.remove();
//        此时抛出了NullPointerException：因为此时返回结果为null，所以不能进行引用，强行引用就抛出了空指针异常
//        int head = queue.peek();
//        int head = queue.poll();
//        System.out.println("now, the head of queue: " + head);

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        // 此时回抛出异常：IllegalStateException: Queue full
        // queue.add(6);
        boolean res2 = queue.offer(6);
        System.out.println("the result of function offer: " + res2);
        boolean res3 = queue.contains(6);
        System.out.println("the result of function contains: " + res3);
        // 若队列为空，会抛出NoSuchElementException异常
        int number1 = queue.element();
        System.out.println("the head of queue: " + number1);
        System.out.println("the queue: " + queue);

        int number2 = queue.poll();
        System.out.println("the current head: "+ number2);
        System.out.println("the queue now: " + queue);

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();

        System.out.println("the current head of queue: " + queue.poll());
        System.out.println("the current head of queue: " + queue.peek());
    }
}
