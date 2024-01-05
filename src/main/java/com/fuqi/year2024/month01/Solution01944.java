package com.fuqi.year2024.month01;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/1/5 20:07
 * @description 1944. 队列中可以看到的人数
 */
public class Solution01944 {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        if (n < 2) return new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = n-1; i >= 0; i--) {
            int height = heights[i];
            while (!stack.isEmpty() && stack.peekFirst() < height) {
                stack.pollFirst();
                ans[i]++;
            }
            if (!stack.isEmpty()) ans[i]++;
            stack.offerFirst(height);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] heights = {10,6,8,5,11,9};
        Solution01944 solution01944 = new Solution01944();
        int[] ans = solution01944.canSeePersonsCount(heights);
    }
}
