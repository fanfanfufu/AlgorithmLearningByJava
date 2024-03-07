package com.fuqi.year2024.month03;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/3/7 22:03
 * @description
 */
public class Solution02575 {
    public int[] divisibilityArray(String word, int m) {
        char[] s = word.toCharArray();
        int[] ans = new int[s.length];
        long x = 0;
        for (int i = 0; i < s.length; i++) {
            x = (x*10 + (s[i]-'0')) % m;
            if (x == 0) ans[i] = 1;
        }

        return ans;
    }
}
