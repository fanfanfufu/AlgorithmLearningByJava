package com.fuqi.year2024.month09;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/9/19 23:05
 * @description
 */
public class Solution02414 {
    public int longestContinuousSubstring(String s) {
        int ans = 1, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)+1)
                cur++;
            else cur = 1;
            ans = Math.max(ans, cur);
        }

        return ans;
    }
}
