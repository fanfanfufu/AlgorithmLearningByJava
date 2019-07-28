package com.fuqi.month07.pinduoduo;

import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/7/28 13:45
 * @Version V1.0
 */
public class Pin1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String[] numstr1 = str1.split(" ");
        int[] arr1 = new int[numstr1.length];
        for(int i = 0; i < numstr1.length; i ++) {
            arr1[i] = Integer.parseInt(numstr1[i]);
        }

        String str2 = scanner.nextLine();
        String[] numstr2 = str2.split(" ");
        int[] arr2 = new int[numstr2.length];
        for(int i = 0; i < numstr2.length; i ++) {
            arr2[i] = Integer.parseInt(numstr2[i]);
        }
        scanner.close();
        operate(arr1, arr2);
    }

    public static void operate(int[] arr1, int[] arr2){
        if (arr1 == null && arr2 == null){
            return;
        }
        int pre = 0, after = 0, index = 0;
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] <= arr1[i-1]){
                pre = arr1[i-1];
                if (i == arr1.length - 1){
                    after = Integer.MAX_VALUE;
                }else {
                    after = arr1[i+1];
                }
                index = i;
                break;
            }
        }

        int ans = pre;
        for (int num : arr2) {
            if (pre < num && num < after){
                ans = Math.max(ans, num);
            }
        }

        if (ans == pre){
            System.out.println("NO");
        }else {
            arr1[index] = ans;
            for (int num : arr1) {
                System.out.print(num + " ");
            }
        }
    }
}
