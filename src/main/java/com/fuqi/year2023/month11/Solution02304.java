package com.fuqi.year2023.month11;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/11/22 22:04
 * @description
 */
public class Solution02304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[2][n];
        dp[0] = grid[0].clone();
        int cur = 0;
        for (int i = 1; i < m; i++) {
            int next = 1 - cur;
            for (int j = 0; j < n; j++) {
                dp[next][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    dp[next][j] = Math.min(dp[next][j], dp[cur][k] + moveCost[grid[i-1][k]][j] + grid[i][j]);
                }
            }
            cur = next;
        }

        return Arrays.stream(dp[cur]).min().getAsInt();
    }
}
