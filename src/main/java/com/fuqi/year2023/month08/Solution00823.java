package com.fuqi.year2023.month08;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/29 21:26
 * @description
 */
public class Solution00823 {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;
        Arrays.sort(arr);
        long[] dp = new long[n];
        long res = 0, mod = 1000000007;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int left = 0, right = i-1; left <= right; left++) {
                while (right >= left && (long) arr[left] * arr[right] > arr[i]) right--;
                if (right >= left && (long) arr[left] * arr[right] == arr[i]) {
                    if (right != left) dp[i] = (dp[i] + dp[left] * dp[right] * 2) % mod;
                    else dp[i] = (dp[i] + dp[left] * dp[right]) % mod;
                }
            }
            res = (res + dp[i]) % mod;
        }

        return (int) res;
    }
}
