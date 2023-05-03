package com.fuqi.year2023.month05;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/3 16:03
 * @description
 */
public class Solution01003 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        String replace = s.replace("abc", "");

        if (replace.length() == 0) return true;
        if (replace.length() == s.length()) return false;

        return isValid(replace);
    }

    public static void main(String[] args) {
        Solution01003 solution01003 = new Solution01003();
        String s = "abccbaabcabc";
        System.out.println(s.replace("abc", ""));
    }
}
