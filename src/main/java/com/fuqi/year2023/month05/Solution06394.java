package com.fuqi.year2023.month05;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/27 22:38
 * @description
 */
public class Solution06394 {
    public int minExtraChar(String s, String[] dictionary) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        Set<String> dictSet = Arrays.stream(dictionary).collect(Collectors.toSet());
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dictSet.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("leetscode".replace("leetcode", ""));
    }
}
