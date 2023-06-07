package com.fuqi.year2023.month06;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/7 22:46
 * @description
 */
public class Solution00494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) return 0;
        int neg = diff/2;
        int n = nums.length;
        int[][] dp = new int[n+1][neg+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i-1];
            for (int j = 0; j <= neg; j++) {
                if (j < num) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - num];
                }
            }
        }

        return dp[n][neg];
    }
}
