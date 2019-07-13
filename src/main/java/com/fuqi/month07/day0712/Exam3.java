package com.fuqi.month07.day0712;

import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/7/12 21:07
 * @Version V1.0
 */
public class Exam3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(n);
        scanner.close();
        long startTime = System.currentTimeMillis();
        long x = 1;
        boolean flag = true;
        while (x < Long.MAX_VALUE){
            double sumxn = x * x + n;
            double y_N = Math.sqrt(sumxn);
            long y = (long) y_N;
            if (y == y_N){
                System.out.println(x);
                flag = false;
                break;
            }
            x++;
        }
        if (flag){
            System.out.println(-1);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("time used: " + (endTime-startTime));
    }
}
