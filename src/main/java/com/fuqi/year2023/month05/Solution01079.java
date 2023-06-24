package com.fuqi.year2023.month05;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/19 21:12
 * @description 活字印刷
 */
public class Solution01079 {
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        if (n < 2) return n;
        int[] cnt = new int[26];
        for (char ch : tiles.toCharArray()) {
            cnt[ch - 'A']++;
        }

        return dfs(cnt);
    }

    private int dfs(int[] cnt) {
        int ans = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                ans++;
                cnt[i]--;
                ans += dfs(cnt);
                cnt[i]++;
            }
        }

        return ans;
    }
}
