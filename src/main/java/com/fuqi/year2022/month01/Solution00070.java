package com.fuqi.year2022.month01;

/**
 * @author FuQi
 * @date 2022/1/15 23:52
 * @description 爬楼梯（每次只能走1阶或2阶），入门级动态规划
 */
public class Solution00070 {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] ans = new int[n+1];
        ans[1] = 1;
        ans[2] = 2;
        for (int i = 3; i < n+1; i++) {
            ans[i] = ans[i-2] + ans[i-1];
        }

        return ans[n];
    }
}
