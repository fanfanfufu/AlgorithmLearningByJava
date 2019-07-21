package com.fuqi.month07.day0721;

import java.util.Arrays;

/**
 * @Description
 * @Team: 电子科技大学自动化研究所
 * @Author: 傅琦
 * @DateTime: 2019/7/21 10:28
 * @Version: V1.0
 */
public class Exam3 {
    int[][] mx;
    int[][] dp;
    int n;

    public int mctFromLeafValues(int[] arr) {
        n = arr.length;
        mx = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int m = arr[i];
                for (int k = i; k <= j; k++) {
                    m = Math.max(m, arr[k]);
                }
                mx[i][j] = m;
            }
        }

        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(arr, 0, n-1);
    }

    int solve(int[] arr, int l, int r){
        if (l == r){
            return 0;
        }
        if (dp[l][r] != -1){ return dp[l][r]; }

        int res = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            int[] a = new int[i - l + 1];
            int[] b = new int[r - i];
            int ma = mx[l][i];
            int mb = mx[i+1][r];

            int temp = ma * mb;
            temp += solve(a, l, i);
            temp += solve(b, i+1, r);
            res = Math.min(res, temp);
        }
        dp[l][r] = res;
        return res;
    }
}
