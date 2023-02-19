package com.fuqi.year2023.month02;

/**
 * @author FuQi
 * @date 2023/2/19 11:03
 * @description
 */
public class Solution06365 {
    public int minOperations(int n) {
        // 特殊的1，2，直接返回
        if (n < 3) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            String binaryString = Integer.toBinaryString(i);
            int bitLen = binaryString.length();
            int upper = 1 << bitLen;
            int lower = 1 << (bitLen - 1);
            if (i == lower) {
                // i刚好为一个2的幂次的数，那么其消解为0的最小操作次数就是1
                dp[i] = 1;
                continue;
            }
            dp[i] = Math.min(dp[upper - i], dp[i - lower]) + 1;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(54));
        System.out.println(Integer.toBinaryString(39));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(83));
        System.out.println(Integer.toBinaryString(116));

        Solution06365 solution06365 = new Solution06365();
        System.out.println(solution06365.minOperations(54));
        System.out.println(solution06365.minOperations(39));
        System.out.println(solution06365.minOperations(3));
        System.out.println(solution06365.minOperations(83));
        System.out.println(solution06365.minOperations(116));
    }
}
