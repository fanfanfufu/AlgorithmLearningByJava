package com.fuqi.month07.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Team 电子科技大学自动化研究所
 * @Author 傅琦
 * @date 2019/7/28 13:45
 * @Version V1.0
 */
public class Pin4 {
    public static void main(String args[])throws Exception{
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][num];
        for(int i = 0; i < num; i++) {
            arr[i][0] = sc.nextInt();
        }
        for(int i = 0; i < num; i++) {
            arr[i][1] = sc.nextInt();
        }
        System.out.println(helper(arr));
    }

    private static int helper(int[][] arr){
        Arrays.sort(arr, (i1, i2) -> (i2[0] - i1[0]));
        int len = arr.length, max = 1;
        final int MAX = 7 * 1000 + 1;
        int[][] dp = new int[len][MAX];
        for(int i = 0; i + 1 < len; i++){
            max = Math.max(max, 1 + recursion(arr, dp, i + 1, 7 * arr[i][1]));
        }
        return max;
    }

    private static int recursion(int[][] arr, int[][] dp, int index, int rest){
        int len = dp.length, max = 1;
        if(rest < arr[index][1]) {
            return 0;
        }
        if(dp[index][rest] != 0){
            return dp[index][rest];
        }
        for(int i = index + 1; i < len; i++){
            max = Math.max(max, 1 + recursion(arr, dp, i, Math.min(rest - arr[i][1], 7 * arr[i][1])));
        }
//        System.out.println("i:" + index + " rest:" + rest + " val:" + max);
        dp[index][rest] = max;
        return max;
    }
}
