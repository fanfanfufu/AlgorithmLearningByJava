package com.fuqi.year2022.month07;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author FuQi
 * @date 2022/7/6 23:30
 * @description
 */
public class Solution00155 {
    class MinStack {

        private Deque<Integer> xStack;
        private Deque<Integer> minStack;


        public MinStack() {
            xStack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.offerFirst(Integer.MAX_VALUE);
        }

        public void push(int val) {
            xStack.offerFirst(val);
            minStack.offerFirst(Math.min(minStack.peekFirst(), val));
        }

        public void pop() {
            xStack.pollFirst();
            minStack.pollFirst();
        }

        public int top() {
            return xStack.peekFirst();
        }

        public int getMin() {
            return minStack.peekFirst();
        }
    }
}
