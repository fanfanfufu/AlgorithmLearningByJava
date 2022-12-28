package com.fuqi.year2022.month12;

/**
 * @author FuQi
 * @date 2022/12/28 22:11
 * @description
 */
public class Solution00009 {
    /**
     * 方法一：转为string处理
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        String s = String.valueOf(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    /**
     * 不转化位字符串进行判断
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        int y = 0;
        int x1 = x;
        while (x1 > 0) {
            int i = x1 % 10;
            y = y * 10 + i;
            x1 /= 10;
        }

        return x == y;
    }
}
