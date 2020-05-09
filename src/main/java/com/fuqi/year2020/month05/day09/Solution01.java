package com.fuqi.year2020.month05.day09;

import java.util.Scanner;

/**
 * @Description: LeetCode69
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * @Author 傅琦
 * @date 2020/5/9 17:25
 * @Version V1.0
 */
public class Solution01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        Solution01 solution01 = new Solution01();
        System.out.println(solution01.mySqrt1(x));
        scanner.close();
//        System.out.println(46341*46341);
    }

    /**
     * 方法一：暴力搜索
     * 时间复杂度：O(sqrt(x))
     */
    public int mySqrt1(int x) {
        if (x < 0){ return 0; }
        if (x == 0 || x == 1){ return x; }

        for (int i = 1; i < 46341; i++) {
            if (x < i*i){ return i-1; }
            if (x == i*i) { return i; }
        }
        
        return 46340;
    }

    /**
     * 方法二：计算器算法
     * 时间复杂度：O(1)O(1)，由于内置的 exp 函数与 log 函数一般都很快，我们在这里将其复杂度视为 O(1)O(1)。
     *
     * 空间复杂度：O(1)O(1)。
     *
     * @param x
     * @return int
     */
    public int mySqrt2(int x){
        if (x == 0){ return 0; }

        int ans = (int) Math.exp(0.5 * Math.log(x));

        return ((long) (ans + 1) * (ans + 1)) <= x ? ans+1 : ans;
    }

    /**
     * 方法三：二分查找法
     *
     * 时间复杂度：O(logx)，即为二分查找需要的次数。
     * 空间复杂度：O(1)。
     *
     * @param x
     * @return int
     */
    public int mySqrt3(int x){
        if (x < 0){ return 0; }
        if (x == 0 || x == 1){ return x; }

        int left = 0, right = x, ans = -1;

        while (left < right){
            int mid = (left + (right - 1)) / 2;
            if ((long) mid * mid <= x){
                ans = mid;
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return ans;
    }

    /**
     * 方法四：牛顿迭代法
     *
     * 时间复杂度：O(logx)，此方法是二次收敛的，相较于二分查找更快。
     * 空间复杂度：O(1)。
     *
     * @param x
     * @return
     */
    public int mySqrt4(int x){
        if (x == 0){ return 0; }

        double C = x, x0 = x;
        while (true){
            double xi = 0.5 * ((x0 + C) / x0);
            if (Math.abs(x0 -xi) < 1e-7){
                break;
            }
            x0 = xi;
        }

        return (int) x0;
    }

}
