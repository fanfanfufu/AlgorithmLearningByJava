package com.fuqi.year2020.month05.day12;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 最小栈
 * @Author 傅琦
 * @date 2020/5/12 9:56
 * @Version V1.0
 */
public class LeetCode155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

}

class MinStack {
    /** initialize your data structure here. */
    private Deque<Integer> stack;
    private int min;

    public MinStack() {
        stack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min){
            stack.offerFirst(min);
            min = x;
        }
        stack.offerFirst(x);
    }

    public void pop() {
        // 如果栈顶元素值最小，则刷新min的值
        if (stack.pollFirst() == min){
            min = stack.pollFirst();
        }
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return min;
    }
}
