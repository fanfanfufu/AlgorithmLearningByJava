package com.fuqi.year2022.month08;

/**
 * @author FuQi
 * @date 2022/8/20 20:12
 * @description
 */
public class Solution00221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        int maxSide = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i-1][j-1] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }

        return maxSide * maxSide;
    }
}
