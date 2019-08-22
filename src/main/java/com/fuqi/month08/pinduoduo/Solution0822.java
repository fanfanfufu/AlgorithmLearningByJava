package com.fuqi.month08.pinduoduo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Description: 二面面试题
 *
 * 一个一维坐标上的一个目标线段，一组源线段，判断目标线段是否能被完全覆盖。
 * 覆盖是指：
 * 目标线段的一部分至少包含于一个源线段之中。
 *
 *         double[] target1 = {3, 8};
 *         double[][] srcs1 = {{2, 9}};
 *         // true
 *         System.out.println(judge(target1, srcs1));
 *
 *         double[] target2 = {3, 8};
 *         double[][] srcs2 = {{5,10},{1,4},{2,3},{3,6}};
 *         // true
 *         System.out.println(judge(target2, srcs2));
 *
 *         double[] target3 = {1.56, 3.02};
 *         double[][] srcs3 = {{0.8,  5.7}};
 *         // true
 *         System.out.println(judge(target3, srcs3));
 *
 *         double[] target4 = {2, 6};
 *         double[][] srcs4 = {{3, 10}};
 *         // false
 *         System.out.println(judge(target4, srcs4));
 *
 *         double[] target5 = {0.5, 3.2};
 *         double[][] srcs5 = {{2,5}, {0,1}};
 *         // false
 *         System.out.println(judge(target5, srcs5));
 *
 * @Author: 傅琦
 * @DateTime: 2019/8/22 19:59
 * @Version: V1.0
 */
public class Solution0822 {
    private static boolean judge(double[] target, double[][] srcs){
        if (srcs.length == 0){ return false; }

        // 根据源线段的起点升序排序
        Arrays.sort(srcs, new Comparator<double[]>() {
            @Override
            public int compare(double[] src1, double[] src2) {
                return (int) Math.floor(src1[0] - src2[0]);
            }
        });

        if (srcs[0][0] > target[0]){
            return false;
        }

        if (srcs[0][1] > target[1]){
            return true;
        }

        for (double[] src : srcs) {
            if (src[0] < target[0] && src[1] > target[1]){
                return true;
            }
            if (src[1] < target[1] && src[1] > target[0]){
                target[0] = src[1];
            }
        }

        return target[0] > target[1];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        double[] target = new double[2];
        String[] temp1 = s1.trim().split(",");
        for (int i = 0; i < target.length; i++) {
            target[i] = Double.valueOf(temp1[i]);
        }

        int n = Integer.valueOf(scanner.nextLine());

        double[][] srcs = new double[n][2];
        for (int i = 0; i < n; i++) {
            String si = scanner.nextLine();
            String[] tempi = si.trim().split(",");
            for (int j = 0; j < tempi.length; j++) {
                srcs[i][j] = Double.valueOf(tempi[j]);
            }
        }

        System.out.println(judge(target, srcs));

        scanner.close();
    }
}
