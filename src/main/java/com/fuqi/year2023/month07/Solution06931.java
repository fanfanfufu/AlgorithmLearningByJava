package com.fuqi.year2023.month07;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/23 00:24
 * @description
 */
public class Solution06931 {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        dp[0][1-nums[0]&1] = -x;
        dp[0][nums[0]&1] = nums[0];
        for (int i = 1; i < n; i++) {
            int c = nums[i] & 1;
            dp[i][c] = Math.max(dp[i-1][c], dp[i-1][1-c] - x) + nums[i];
            dp[i][1-c] = dp[i-1][1-c];
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
