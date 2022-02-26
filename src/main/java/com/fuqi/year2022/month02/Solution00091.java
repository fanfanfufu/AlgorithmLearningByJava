package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/26 22:16
 * @description
 */
public class Solution00091 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
            if (i > 1 && s.charAt(i-2) != '0' && ((s.charAt(i-2)-'0') * 10 + (s.charAt(i-1) - '0') <=26)) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
}
