package com.fuqi.year2022.month02;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2022/2/27 15:00
 * @description
 */
public class Solution00072 {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if (n == 0 || m == 0) {
            return n+m;
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left = dp[i][j-1] + 1;
                int up = dp[i-1][j] + 1;
                int left_up = dp[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    left_up += 1;
                }
                dp[i][j] = Math.min(left_up, Math.min(left, up));
            }
        }

        return dp[n][m];
    }
}
