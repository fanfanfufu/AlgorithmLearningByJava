package com.fuqi.year2019.month08.beikezhengshipi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/23 19:22
 * @Version V1.0
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums =new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
            sum += nums[i];
        }
        helper(nums, sum);

        scanner.close();
    }

    private static void helper(int[] nums, int sum){
        int num=0;
        Arrays.sort(nums);
        int[] dp =new int[sum/2+1];
        for(int i=0;i<nums.length;i++) {
            for(int j=sum/2;j>=nums[i];j--){
                int temp=dp[j];
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
                if(dp[j]==(temp+nums[i])&&j==sum/2) {
                    num++;
                }
            }
        }
        int res1 =sum-2*dp[sum/2];
        System.out.println(res1);
        System.out.println(Math.abs(2*num-nums.length));
    }


    private static void helper1(int[] nums) {
        Arrays.sort(nums);
        List<Integer> heap1 = new ArrayList<>();
        List<Integer> heap2 = new ArrayList<>();

        int i = 0, j = nums.length-1;
        // 两堆各添加一个数，保证和只差尽可能小
        heap1.add(nums[i]);
        int sum1 = nums[i];
        heap2.add(nums[j]);
        int sum2 = nums[j];
        int sumDiff = sum2 - sum1;
        int numDiff = 0;
        i++;
        j--;

        while (i <= j) {
            int tempDiff1 = Math.abs(sum2 - (sum1+nums[i]));
            int tempDiff2 = Math.abs(sum2 + nums[j] - sum1);
            if (tempDiff1 < tempDiff2) {
                heap1.add(nums[i]);
                sum1 += nums[i];
                i++;
                sumDiff = tempDiff1;
            }else {
                heap2.add(nums[j]);
                sum2 += nums[j];
                j--;
                sumDiff = tempDiff2;
            }
        }
        System.out.print(sumDiff);
        System.out.print(" " + Math.abs(heap1.size() - heap2.size()));
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = scanner.nextInt();
//        }
//        helper(nums);
//
//        scanner.close();
//    }
}
