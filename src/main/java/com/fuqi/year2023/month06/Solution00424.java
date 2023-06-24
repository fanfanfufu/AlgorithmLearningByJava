package com.fuqi.year2023.month06;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/6 23:41
 * @description
 */
public class Solution00424 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) return len;
        char[] charArr = s.toCharArray();
        int left = 0, right = 0;

        int ans = 0;
        int maxCount = 0;
        int[] freq = new int[26];
        while (right < len) {
            freq[charArr[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[charArr[right]-'A']);
            right++;

            if (right - left > maxCount + k) {
                freq[charArr[right]-'A']--;
                left++;
            }

            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}
