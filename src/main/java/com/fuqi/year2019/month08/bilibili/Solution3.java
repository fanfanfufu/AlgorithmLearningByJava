package com.fuqi.year2019.month08.bilibili;

import java.util.Scanner;

/**
 * @Description: 背包问题
 * @Author 傅琦
 * @date 2019/8/20 18:56
 * @Version V1.0
 */
public class Solution3 {
    /**
     *
     * @param total 重量上限
     * @param weight 各个物品的重量
     * @param value 各个物品的价值
     * @return
     */
    private static int findMax(int total, int[] weight, int[] value){
        int[][] record = new int[weight.length + 1][total + 1];
        for (int i = 1; i < weight.length+1; i++) {
            for (int j = 1; j < total+1; j++) {

                if (j < weight[i-1]){
                    record[i][j] = record[i-1][j];
                }else {
                    record[i][j] = Math.max(record[i-1][j], record[i-1][j-weight[i-1]] + value[i-1]);
                }
            }
        }
        return record[weight.length][total];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantity = scanner.nextInt();
        int total = scanner.nextInt();

        int[] weights = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            weights[i] = scanner.nextInt();
        }

        int[] values = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            values[i] = scanner.nextInt();
        }

        System.out.println(findMax(total, weights, values));
        scanner.close();
    }
}
