package com.fuqi.year2023.month06;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/4 10:46
 * @description
 */
public class Solution06462 {
    public int minimizedStringLength(String s) {
        if (s.length() == 1) return s.length();
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch-'a'] = 1;
        }

        return Arrays.stream(cnt).sum();
    }

    public static void main(String[] args) {
        Solution06462 solution06462 = new Solution06462();
        String s = "abcabc";
        System.out.println(solution06462.minimizedStringLength(s));
    }
}
