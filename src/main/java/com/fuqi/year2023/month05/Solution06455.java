package com.fuqi.year2023.month05;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/28 11:06
 * @description
 */
public class Solution06455 {
    public long minimumCost(String s) {
        long ans = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(i, n-i);
            }
        }

        return ans;
    }
}
