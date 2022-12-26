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
                // 1. 只看当前1位，当前下标字符的节码方法总数于前一下标的相等
                dp[i] = dp[i-1];
            }
            if (i > 1 && s.charAt(i-2) != '0' && ((s.charAt(i-2)-'0') * 10 + (s.charAt(i-1) - '0') <=26)) {
                // 2. 往前看两位，就需要将两位前的总数加上
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
}
