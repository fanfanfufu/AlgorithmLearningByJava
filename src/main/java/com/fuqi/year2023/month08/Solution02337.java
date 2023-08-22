package com.fuqi.year2023.month08;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/21 23:18
 * @description
 */
public class Solution02337 {
    public boolean canChange(String start, String target) {
        int n = start.length();
        if (n == 1) return start.equals(target);
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;
            if (i < n && j < n) {
                if (start.charAt(i) != target.charAt(j)) return false;
                char sc = start.charAt(i);
                if ((sc == 'L' && i < j) || (sc == 'R' && i > j)) return false;
                i++;
                j++;
            }
        }

        while (i < n) {
            if (start.charAt(i) != '_') return false;
            i++;
        }

        while (j < n) {
            if (target.charAt(j) != '_') return false;
            j++;
        }

        return true;
    }
}
