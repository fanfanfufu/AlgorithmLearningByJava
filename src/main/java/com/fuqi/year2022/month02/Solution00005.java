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
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // L代表字串长度
        for (int L = 2; L <= len; L++) {
            // i位左端点
            for (int i = 0; i < len; i++) {
                // j 为右端点
                int j = L + i - 1;
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j-i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && j-i+1 > maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin+maxLen);
    }
}
