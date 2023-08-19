package com.fuqi.year2023.month08;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/19 22:36
 * @description
 */
public class Solution08014 {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        if (n2 > n1) return false;
        int i1 = 0, i2 = 0;
        while (i1 < n1 && i2 < n2) {
            char ch1 = str1.charAt(i1);
            char ch2 = str2.charAt(i2);
            if (ch1 == ch2) {
                i1++;
                i2++;
                continue;
            }
            if ((ch1 - 'a' + 1) == (ch2 - 'a')) {
                i1++;
                i2++;
                continue;
            }
            if (ch1 == 'z' && ch2 == 'a') {
                i1++;
                i2++;
                continue;
            }
            i1++;
        }

        return i2 == n2;
    }

    public static void main(String[] args) {
        Solution08014 solution08014 = new Solution08014();
        String str1 = "abc";
        String str2 = "ad";
        System.out.println(solution08014.canMakeSubsequence(str1, str2));
    }
}
