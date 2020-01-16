package com.fuqi.year2019.month08.beike;

import java.util.Scanner;

/**
 * @Description: 找出相邻两数数字中差的绝对值最小的一对数字
 * @Author 傅琦
 * @date 2019/8/10 18:57
 * @Version V1.0
 */
public class Main1 {

    private static int[] helper(int[] arr){
        int[] ans = new int[2];
        if (arr.length < 2 || arr[0] <= 0){
            return ans;
        }

        long diff = Long.MAX_VALUE;

        for (int i = 1; i < arr.length && arr[i] > 0; i++) {
            long temp = Math.abs(arr[i] - arr[i-1]);
            if (temp < diff){
                diff = temp;
                ans[0] = arr[i-1];
                ans[1] = arr[i];
                if (temp == 0){
                    return ans;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = scanner.nextInt();
        int[] nums = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] res = helper(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}
