package com.fuqi.year2022.month07;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author FuQi
 * @date 2022/7/4 20:07
 * @description 双向队列经典提
 */
public class Solution00239 {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int n = nums.length;
        PriorityQueue<int[]> bigHeap = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (int i = 0; i < k; i++) {
            bigHeap.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = bigHeap.peek()[0];
        for (int i = k; i < n; i++) {
            bigHeap.offer(new int[]{nums[i], i});
            while (bigHeap.peek()[1] <= (i - k)) {
                bigHeap.poll();
            }
            ans[i-k+1] = bigHeap.peek()[0];
        }

        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 2) {
            return nums;
        }
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() <= (i-k)) {
                deque.pollFirst();
            }
            if (i+1 >= k) {
                ans[i-k+1] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }
}
