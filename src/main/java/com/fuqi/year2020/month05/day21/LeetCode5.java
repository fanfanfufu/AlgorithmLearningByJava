package com.fuqi.year2020.month05.day21;

/**
 * @Description: 最长回文子串
 * @Author: 傅琦
 * @DateTime: 2020/5/21 10:24
 * @Version: V1.0
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1){ return ""; }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以当前字符为中心
            int len1 = expandAroundCenter(s, i, i);
            // 以当前字符及其相邻字符为中心
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            // 找到一个最长字串后，将指针定位到其两侧
            if (len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }

    /**
     * 中心扩展法
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        while (L >= 0 && R < s.length() && (s.charAt(L) == s.charAt(R))){
            L--;
            R++;
        }
        return R - L - 1;
    }
}
