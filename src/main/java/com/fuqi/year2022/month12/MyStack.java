package com.fuqi.year2022.month12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author FuQi
 * @date 2022/12/16 23:17
 * @description
 */
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        // 使用两个队列
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        // 使用单个队列
//        int n = queue1.size();
//        queue1.offer(x);
//        for (int i = 0; i < n; i++) {
//            queue1.offer(queue1.poll());
//        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
