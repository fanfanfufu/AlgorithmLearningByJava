package com.fuqi.year2024.month04;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/4/10 23:11
 * @description
 */
public class Solution01702 {
    public String maximumBinaryString(String binary) {
        int n = binary.length(), i = binary.indexOf('0');
        if (i < 0) {
            return binary;
        }
        int zeros = 0;
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (binary.charAt(j) == '0') {
                zeros++;
            }
            s.append('1');
        }
        s.setCharAt(i + zeros - 1, '0');
        return s.toString();
    }
}
