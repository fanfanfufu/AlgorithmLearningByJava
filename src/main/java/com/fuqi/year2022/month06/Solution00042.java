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
     * 动态规划的空间复杂度优化版
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int left = 0, right = n-1;
        int leftMax = height[left], rightMax = height[right];
        int ans = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            if (leftHeight < rightHeight) {
                leftMax = Math.max(leftHeight, leftMax);
                ans += leftMax - leftHeight;
                left++;
            } else {
                rightMax = Math.max(rightHeight, rightMax);
                ans += rightMax - rightHeight;
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

    public int trap3(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i-1], height[i]);
        
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i+1], height[i]);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }
}
