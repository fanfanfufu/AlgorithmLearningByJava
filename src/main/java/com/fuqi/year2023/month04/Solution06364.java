package com.fuqi.year2023.month04;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/2 11:22
 * @description
 */
public class Solution06364 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        if (k == 0) return Arrays.stream(reward2).sum();
        if (k == n) return Arrays.stream(reward1).sum();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            reward1[i] -= reward2[i];
        }
        Arrays.sort(reward1);
        for (int i = n-k; i < n; i++) {
            ans += reward1[i];
        }
        return ans;
    }
}
