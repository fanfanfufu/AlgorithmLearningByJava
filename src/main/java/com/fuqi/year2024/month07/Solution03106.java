package com.fuqi.year2024.month07;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/7/27 14:57
 * @description
 */
public class Solution03106 {
    public String getSmallestString(String s, int k) {
        if (k == 0) return s;
        char[] ans = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int dis = Math.min(s.charAt(i)-'a', 'z' - s.charAt(i)+1);
            if (dis <= k) {
                ans[i] = 'a';
                k -= dis;
            } else {
                ans[i] -= k;
                break;
            }
        }

        return new String(ans);
    }
}
