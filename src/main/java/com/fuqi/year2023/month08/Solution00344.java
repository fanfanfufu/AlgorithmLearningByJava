package com.fuqi.year2023.month08;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/7 23:13
 * @description
 */
public class Solution00344 {
    public void reverseString(char[] s) {
        int n = s.length;
        if (n == 1) return;
        int left = 0, right = n - 1;
        while (left < right) {
            if (s[left] != s[right]) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
            }
            left++;
            right--;
        }
    }
}
