package com.fuqi.year2019.month08.beike;

import java.util.Scanner;

/**
 * @Description: 月光宝盒的密码
 * @Author 傅琦
 * @date 2019/8/10 18:57
 * @Version V1.0
 */
public class Main2 {

    private static int helper(int[] arr){
        if (arr.length < 2){ return 0; }

        int[] dp = new int[arr.length + 1];
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(helper(arr));
    }
}
