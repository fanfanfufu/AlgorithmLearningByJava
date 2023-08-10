package com.fuqi.year2023.month08;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/10 22:56
 * @description
 */
public class Solution01289 {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 1) return grid[0][0];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[0][i] = grid[0][i];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    dp[i][j] = Math.min(dp[i-1][k] + grid[i][j], dp[i][j]);
                }
            }
        }

        int ans = dp[n-1][0];
        for (int i = 1; i < n; i++) ans = Math.min(ans, dp[n-1][i]);

        return ans;
    }
}
