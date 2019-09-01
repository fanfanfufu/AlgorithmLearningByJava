package com.fuqi.month09.拼多多寻梦;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/9/1 16:36
 * @Version: V1.0
 */
public class Main3 {
    private static void helper(int[] arr) {
        double ans = 0;
        for (int i = 0; i < arr.length; i++) {
            double temp1 = 1 / (double) arr[i];
            double temp2 = (temp1 * i) / arr[i];
            ans += temp2;
        }

        BigDecimal b = new BigDecimal(ans);
        float res = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        helper(arr);
        scanner.close();
    }
}
