package com.fuqi.year2019.month08.pinduoduo;

import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/11 14:55
 * @Version V1.0
 */
public class Main3 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int S = scanner.nextInt();

        long[][] dp = new long[N+1][S+1];

        dp[0][0] = 1;
        for (int i=0;i<N;++i){
            int bas = (N-i);
            for (int now=bas; now <= S;++now){
                dp[i+1][now] = (dp[i+1][now-bas] + dp[i][now-bas]) % MOD;
            }
        }
        System.out.println(dp[N][S]);

        scanner.close();
    }
}
