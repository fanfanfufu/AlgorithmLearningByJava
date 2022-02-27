package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/27 16:48
 * @description
 */
public class Solution00343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i-j), j * dp[i-j]));
            }
            dp[i] = curMax;
        }

        return dp[n];
    }

    public int integerBreak2(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }
}
