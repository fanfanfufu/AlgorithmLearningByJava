package com.fuqi.year2023.month06;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/24 15:41
 * @description
 */
public class Solution00503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n - 1; i++) {
            int j = i % n;
            while (!stack.isEmpty() && nums[j] > nums[stack.peekFirst()]) {
                int index = stack.pollFirst();
                ans[index] = nums[j];
            }
            stack.offerFirst(j);
        }

        return ans;
    }
}
