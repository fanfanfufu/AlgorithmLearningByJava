package com.fuqi.month08.beike;

import java.util.Scanner;

/**
 * @Description: 特殊的测试
 * @Author 傅琦
 * @date 2019/8/10 18:57
 * @Version V1.0
 */
public class Main4 {
    private static long helper(int[] arr){

        long ans = 0;
        int[] dp = new int[arr.length];

        // 先求递增的最小代价
        int pre = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = dp[i-1] + Math.max(0, pre - arr[i] + 1);
            pre = Math.max(pre + 1, arr[i]);
        }

        // 再求全部递减的最小代价
        pre = arr[arr.length - 1];
        ans = dp[arr.length - 1];
        int cur = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            // 重复加的部分
            int repeat = Math.min(dp[i] - (i == 0 ? 0 : dp[i-1]), Math.max(0, pre - arr[i] + 1));

            cur += Math.max(0, pre - arr[i] + 1);
            pre = Math.max(pre + 1, arr[i]);

            ans = Math.min(dp[i] + cur -repeat, ans);
        }

        return ans;
    }

    private static long helper2(int[] arr){
        long ans = Long.MAX_VALUE;

        int decrese = 0;
        int right = arr[arr.length-1];
        for (int i = arr.length - 2; i >= 0; i--) {
            decrese += Math.max(0, right - arr[i] + 1);
            right = Math.max(right+1, arr[i]);
        }

        ans = Math.min(ans, decrese);

        int increse = 0;
        int left = arr[0];
        for (int i = 1; i < arr.length; i++) {
            increse += Math.max(0, left - arr[i] + 1);
            left = Math.max(left+1, arr[i]);
        }

        ans = Math.min(ans, increse);

        for (int i = 1; i < arr.length; i++) {
            left = arr[0];
            right = arr[arr.length-1];
            increse = 0;
            decrese = 0;

            for (int j = 1; j < i; j++) {
                increse += Math.max(0, left - arr[j] + 1);
                left = Math.max(left+1, arr[j]);
            }

            for (int j = arr.length-2; j > i; j--) {
                decrese += Math.max(0, right - arr[j] + 1);
                right = Math.max(right+1, arr[j]);
            }

            ans = Math.min(ans, (left + right));
        }

        return ans;
    }

    private static int helper(int[] arr, int index){
        int res = 0, len = arr.length;
        if(len == 1)
            return 0;
        int l = arr[0], r = arr[len - 1];
        for(int i = 1; i < index; i++){
            if(l >= arr[i]){
                l ++;
                res += (l - arr[i]);
            }else
                l = arr[i];
        }
        for(int i = len - 2; i > index; i --){
            if(arr[i] <= r){
                r ++;
                res += (r - arr[i]);
            }else
                r = arr[i];
        }
        if(index == 0){
            return arr[0] <= r ? res + (r + 1 - arr[0]) : res;
        }else if(index == len - 1){
            return arr[len - 1] <= l ? res + (l + 1 - arr[len - 1]): res;
        }else{
            return arr[index] <= Math.max(l, r) ? res + Math.max(l, r) + 1 - arr[index] : res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] queue = new int[N];
        for (int i = 0; i < N; i++) {
            queue[i] = scanner.nextInt();
        }

        System.out.println(helper(queue));
    }
}
