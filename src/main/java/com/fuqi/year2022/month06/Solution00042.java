package com.fuqi.year2022.month06;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/6/13 21:24
 * @description 接雨水
 */
public class Solution00042 {
    /**
     * 双指针解法
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        int leftMax = height[0], rightMax = height[height.length-1];
        int left = 1, right = height.length-2;
        while (left <= right) {
            if (height[left-1] < height[right+1]) {
                leftMax = Math.max(height[left-1], leftMax);
                if (leftMax > height[left]) {
                    ans += leftMax-height[left];
                }
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right+1]);
                if (rightMax > height[right]) {
                    ans += rightMax-height[right];
                }
                right--;
            }
        }

        return ans;
    }

    /**
     * 单调栈
     * 总体的原则就是，
     *
     * 当前高度小于等于栈顶高度，入栈，指针后移。
     *
     * 当前高度大于栈顶高度，出栈，计算出当前墙和栈顶的墙之间水的多少，然后计算当前的高度和新栈的高度的关系，重复第 2 步。
     * 直到当前墙的高度不大于栈顶高度或者栈空，然后把当前墙入栈，指针后移。
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int mid = stack.pollFirst();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int h = Math.min(height[left], height[i]) - height[mid];
                res += (i - left - 1) * h;
            }
            stack.offerFirst(i);
        }
        return res;
    }
}
