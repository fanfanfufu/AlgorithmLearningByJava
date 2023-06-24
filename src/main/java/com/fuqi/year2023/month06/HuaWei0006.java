package com.fuqi.year2023.month06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/7 22:55
 * @description
 */
public class HuaWei0006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        in.nextLine();
        int target = in.nextInt();
        System.out.println(getPlanNums(nums, target));
    }

    private static int getPlanNums(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i-1];
            for (int j = 0; j <= target; j++) {
                if (j < num) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-num];
                }
            }
        }

        return dp[n][target];
    }
}
