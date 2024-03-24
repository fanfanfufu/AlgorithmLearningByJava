package com.fuqi.year2024.month03;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/3/20 21:07
 * @description
 */
public class Solution00242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c-'a']++;
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            if (cnt[c-'a'] == 0) return false;
            cnt[index]--;
        }

        return true;
    }
}
