package com.fuqi.year2023.month06;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/3 22:35
 * @description
 */
public class Solution01156 {
    public int maxRepOpt1(String text) {
        int[] cnt = new int[26];
        int n = text.length();
        for (char ch : text.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int ans = 0, i = 0;
        while (i < n) {
            int j = i;
            while (j < n && text.charAt(j) == text.charAt(i)) {
                j++;
            }
            int l = j - i;
            int k = j + 1;
            while (k < n && text.charAt(k) == text.charAt(i)) k++;
            int r = k - j - 1;
            ans = Math.max(ans, Math.min(l + r + 1, cnt[text.charAt(i) - 'a']));
            i = j;
        }

        return ans;
    }
}
