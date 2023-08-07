package com.fuqi.year2023.month08;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/7 23:45
 * @description 判断s是否是t的子序列
 */
public class Solution00392 {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0) return true;
        // 如果t的长度小于s的长度，直接返回false
        if (n < m) return false;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                // 如果两个位置的想等，则右移遍历s的指针
                i++;
            }
            j++;
        }

        return i == m;
    }

    public static void main(String[] args) {
        Solution00392 solution00392 = new Solution00392();
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(solution00392.isSubsequence(s, t));
    }
}
