package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/26 14:20
 * @description 最长回文子串
 */
public class Solution00005 {
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

    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = true;

        char[] charArr = s.toCharArray();
        for (int curLen = 2; curLen <= len; curLen++) {
            for (int left = 0; left < len; left++) {
                int right = left + curLen - 1;
                if (right >= len) break;

                if (charArr[left] == charArr[right]) {
                    if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left+1][right-1];
                    }
                }

                if(dp[left][right] && right-left+1 > maxLen) {
                    maxLen = right-left+1;
                    begin = left;
                }
            }
        }

        return s.substring(begin, begin+maxLen);
    }
}
