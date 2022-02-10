package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/10 22:22
 * @description 盛水最多的容器
 */
public class Solution00011 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int ans = 0;
        while (i < j) {
            int area = (j-i) * Math.min(height[i], height[j]);
            ans = Math.max(ans, area);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }
}
