package com.fuqi.year2023.month07;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/31 22:05
 * @description
 */
public class Solution00013 {
    public int romanToInt(String s) {
        int ans = 0;
        int pre = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int cur = getValue(s.charAt(i));
            if (pre < cur) {
                ans -= pre;
            } else {
                ans += pre;
            }
            pre = cur;
        }
        ans += pre;

        return ans;
    }

    private int getValue (char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
