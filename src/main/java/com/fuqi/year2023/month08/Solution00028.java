package com.fuqi.year2023.month08;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/3 21:53
 * @description 找出字符串中第一个匹配项的下标
 */
public class Solution00028 {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        int i = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int start = i, j = 0;
                while (start < haystack.length() && j < needle.length() && haystack.charAt(start) == needle.charAt(j)) {
                    start++;
                    j++;
                }
                if (j == needle.length()) return i;
                if (start == haystack.length()) return -1;
            }
            i++;
        }

        return -1;
    }
}
