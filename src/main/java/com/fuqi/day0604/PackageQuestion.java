package com.fuqi.day0604;

/**
 * @Description: 01背包问题
 *               所有商品选择最多只能选择一个
 *               所有商品的费用：200 600 100 180 300 450
 *               所有商品的热度：6   10  3   4   5   8
 *               选购商品总经费不超过1000，求能达到的最大热度值。
 * @Author 傅琦
 * @Date 2019/6/5 14:52
 * @Version V1.0
 */
public class PackageQuestion {
    public static void main(String[] args){
        int total = 1000;
        int[] prices = {200,500,100,180,300,450};
        int[] values = {6,10,3,4,5,8};
        int result = findMax(total, prices, values);
        System.out.println(result);
    }

    private static int findMax(int total, int[] price, int[] value){
        int[][] record = new int[price.length + 1][total + 1];
        for (int i = 1; i < price.length+1; i++) {
            for (int j = 1; j < total+1; j++) {

                if (j < price[i-1]){
                    record[i][j] = record[i-1][j];
                }else {
                    record[i][j] = Math.max(record[i-1][j], record[i-1][j-price[i-1]] + value[i-1]);
                }
            }
        }
        return record[price.length][total];
    }
}
