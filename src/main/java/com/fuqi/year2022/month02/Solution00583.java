package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/26 23:34
 * @description
 */
public class Solution00583 {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            char ch1 = word1.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char ch2 = word2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int commonLength = dp[n][m];

        return n-commonLength + m-commonLength;
    }
}
