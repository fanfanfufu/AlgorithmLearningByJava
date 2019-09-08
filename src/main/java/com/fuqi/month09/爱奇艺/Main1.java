package com.fuqi.month09.爱奇艺;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description：
 * @Author 傅琦
 * @date 2019/9/8 16:36
 * @Version V1.0
 */
public class Main1 {
    private static int helper(int N, int[] arr) {
        int MOD = 1000000007;
        int[][] dp = new int[N][N];
        // 第一行全填1
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[i-1] == 1) {
                    for (int k = j; k < i; k++) {
                        dp[i][j] += dp[i-1][k];
                        dp[i][j] %= MOD;
                    }
                } else {
                    for (int k = 0; k < j; k++) {
                        dp[i][j] += dp[i-1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }

        int ans = 0;
        for (int x : dp[N-1]) {
            ans += x;
            ans %= MOD;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] arr = new int[N-1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(helper(N, arr));

        scanner.close();
    }
}
