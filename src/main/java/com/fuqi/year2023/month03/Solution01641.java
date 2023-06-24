package com.fuqi.year2023.month03;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/3/29 22:50
 * @description
 */
public class Solution01641 {
    public int countVowelStrings1(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }

        return Arrays.stream(dp).sum();
    }

    public int countVowelStrings2(int n) {
        return (n+1) * (n+2) * (n+3) * (n+4) / 24;
    }
}
