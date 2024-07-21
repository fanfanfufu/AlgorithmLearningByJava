package com.fuqi.year2024.month07;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/7/21 16:02
 * @description
 */
public class Solution01186 {
    public int maximumSum(int[] arr) {
        int dp0 = arr[0], dp1 = 0, ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp1 = Math.max(dp0, dp1 + arr[i]);
            dp0 = Math.max(dp0, 0) + arr[i];
            ans = Math.max(ans, Math.max(dp0, dp1));
        }

        return ans;
    }
}
