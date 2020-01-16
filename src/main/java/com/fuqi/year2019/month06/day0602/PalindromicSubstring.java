package com.fuqi.year2019.month06.day0602;

/**
 * @Description: 给定字符串s，找到其中长度最长得回文子字符串(从左往右和从右往左读是一样的)，例如"aba","bb","ccbbcc"
 * @Author 傅琦
 * @Date 2019/6/2 17:47
 * @Version V1.0
 */
public class PalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1){ return ""; }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end+1);
    }

    private int expandAroundCenter(String s, int left, int right){
        int L = left;
        int R = right;
        while (L>= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }

        return R - L - 1;
    }
}
