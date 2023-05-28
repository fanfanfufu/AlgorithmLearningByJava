package com.fuqi.year2023.month05;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/28 10:30
 * @description
 */
public class Solution06457 {
    public String removeTrailingZeros(String num) {
        if (num == null || num.length() == 0) return num;
        if (num.length() == 1) return num.replace("0", "");
        int i = num.length() - 1;
        while (i >= 0) {
            if (num.charAt(i) != '0') break;
            i--;
        }

        return num.substring(0, i+1);
    }
}
