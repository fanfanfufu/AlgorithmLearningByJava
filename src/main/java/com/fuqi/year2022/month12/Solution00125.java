package com.fuqi.year2022.month12;

/**
 * @author FuQi
 * @date 2022/12/28 21:51
 * @description
 */
public class Solution00125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
