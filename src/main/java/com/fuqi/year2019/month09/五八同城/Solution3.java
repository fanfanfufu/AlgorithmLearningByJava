package com.fuqi.year2019.month09.五八同城;

import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/9/16 21:04
 * @Version V1.0
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(helper(arr));

        scanner.close();
    }

    private static int helper(int[] arr) {
        //pre记录的是以i结尾的递增子序列长度
        int[] pre = new int[arr.length];
        //last记录的是以i开始的递增子序列长度
        int[] last = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            pre[i] = arr[i] > arr[i-1] ? pre[i-1]+1 : 1;
        }

        for (int i = arr.length-2; i >= 0; i--) {
            last[i] = arr[i+1] > arr[i] ? last[i+1]+1 : 1;
        }

        int ans = 1;
        for (int i = 1; i < arr.length-1; i++) {
            ans = Math.max(ans, pre[i]);
            ans = Math.max(ans, last[i]);
            if(arr[i+1]-arr[i-1] >= 2) {
                ans = Math.max(ans, pre[i-1]+last[i+1]+1);
            }
        }

        return ans;
    }
}
