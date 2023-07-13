package com.fuqi.year2023.month07;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/2 11:32
 * @description
 */
public class Solution06911 {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        // 用于维护子数组内的最大值
        Deque<Integer> maxQ = new ArrayDeque<>();
        // 用于维护子数组内的最小值
        Deque<Integer> minQ = new ArrayDeque<>();
        int len = nums.length;
        int start = 0, end = 0;
        while (end < len) {
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[end]) {
                maxQ.pollLast();
            }
            while (!minQ.isEmpty() && minQ.peekLast() > nums[end]) {
                minQ.pollLast();
            }
            maxQ.offerLast(nums[end]);
            minQ.offerLast(nums[end]);
            // 一直移动左指针，直到最大值或者最小值队列为空或者最大最小元素的差小于等于2
            while(!maxQ.isEmpty() && !minQ.isEmpty() && (maxQ.peekFirst()-minQ.peekFirst() > 2)) {
                if (nums[start] == maxQ.peekFirst()) maxQ.pollFirst();
                if (nums[start] == minQ.peekFirst()) minQ.pollFirst();
                start++;
            }
            ans += (end-start+1);
            end++;
        }

        return ans;
    }
}
