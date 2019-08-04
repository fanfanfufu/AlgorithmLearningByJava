package com.fuqi.month08.DajangA;

import java.util.Scanner;

/**
 * @Description: 多重背包问题
 * @Author 傅琦
 * @date 2019/8/4 20:19
 * @Version V1.0
 */
public class ExamA02 {
    /**
     *
     * @param money 能花的钱的上限
     * @param prices 价格表
     * @param values 满意度表
     * @param quantities 零食的数量表
     * @return 最大满意度
     */
    private static int helper(int money, int[] prices, int[] values, int[] quantities){
        int[][] dp = new int[values.length+1][money+1];

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j <= money; j++) {
                for (int k = 0; k <= quantities[i] && k * prices[i] <= j; k++) {
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j- k*prices[i]] + k * values[i]);
                }
            }
        }

        return dp[values.length][money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int money = scanner.nextInt();

            int[] prices = new int[n];
            int[] values = new int[n];
            int[] quantities = new int[n];

            for (int i = 0; i < n; i++) {
                prices[i] = scanner.nextInt();
                values[i] = scanner.nextInt();
                quantities[i] = scanner.nextInt();
            }

            int res = helper(money, prices, values, quantities);
            System.out.println("res = " + res);
        }
    }
}
