package com.fuqi.month07.day0712;

import java.math.BigDecimal;
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

        long endTime = System.currentTimeMillis();

        System.out.println("time used: " + (endTime-startTime));
    }
}
