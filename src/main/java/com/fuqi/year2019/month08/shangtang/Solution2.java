package com.fuqi.year2019.month08.shangtang;

import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/19 20:02
 * @Version V1.0
 */
public class Solution2 {
    private static int helper(int[] arr, int location) {
        int len = 1;
        int i = location-1, j = location+1;
        int judge = arr[location];
        while (i >= 0 && j < arr.length && arr[i] < judge && judge > arr[j]) {
            len += 2;
            i--;
            j++;
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int temp = helper(arr, i);
            ans = ans > temp ? ans : temp;
        }

        if (ans == 1){
            System.out.println(0);
        }else {
            System.out.println(ans);
        }
        scanner.close();
    }
}
