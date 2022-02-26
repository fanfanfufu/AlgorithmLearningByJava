package com.fuqi.year2022.month02;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author FuQi
 * @date 2022/2/26 16:36
 * @description
 */
public class Solution00139 {
    public static void main(String[] args) {
        String s = "leetcode";
        String leet = s.replace("let", "");
        System.out.println(leet);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
