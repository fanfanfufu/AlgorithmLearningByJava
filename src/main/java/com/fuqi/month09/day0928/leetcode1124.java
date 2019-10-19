package com.fuqi.month09.day0928;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 表现良好的最长时间段
 * 参考链接：https://www.jianshu.com/p/c548dbae322d
 * @Author: 傅琦
 * @DateTime: 2019/9/28 17:07
 * @Version: V1.0
 */
public class leetcode1124 {
    public int longestWPI(int[] hours) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        int[] prefixSum = new int[hours.length+1];
        // 1. 第一次遍历数组，将大于8的设置为1，小于8的设置为-1
        // 并且初始化前缀和数组
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8){
                max = 1;
                hours[i] = 1;
            } else {
                hours[i] = -1;
            }

            prefixSum[i+1] = prefixSum[i] + hours[i];
        }

        // 2. 实现单调栈
        for (int i = 0; i < prefixSum.length - 1; i++) {
            if (stack.isEmpty()){
                stack.push(i);
            } else {
                if (prefixSum[i] < prefixSum[stack.peek()]) {
                    stack.push(i);
                }
            }
        }

        // 3. 从后往前遍历前缀和数组
        for (int i = prefixSum.length-1; i >= 0; i--) {
            int last = i;
            while (!stack.isEmpty() && prefixSum[i] > prefixSum[stack.peek()]) {
                last = stack.pop();
            }

            if (last != i) {
                int width = i - last;
                max = max > width ? max: width;
            }
        }

        return max;
    }
}
