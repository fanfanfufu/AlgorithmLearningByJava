package com.fuqi.year2024.month03;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/3/12 21:41
 * @description
 */
public class Solution00383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] cnt = new int[26];
        for (char ch : magazine.toCharArray()) cnt[ch - 'a']++;
        for (char ch : ransomNote.toCharArray()) {
            int index = ch - 'a';
            cnt[index]--;
            if (cnt[index] < 0) return false;
        }

        return true;
    }
}
