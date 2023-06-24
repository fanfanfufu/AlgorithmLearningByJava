package com.fuqi.year2023.month03;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/3/8 23:01
 * @description
 */
public class Offer47 {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }

        return dp[m][n];
    }
}
