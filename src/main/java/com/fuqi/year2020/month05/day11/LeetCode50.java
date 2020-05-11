package com.fuqi.year2020.month05.day11;

/**
 * @Description: 实现pow(x, n)
 * @Author 傅琦
 * @date 2020/5/11 9:28
 * @Version V1.0
 */
public class LeetCode50 {
    public static void main(String[] args) {
        double x = 2.1;
        int n = 3;
        LeetCode50 leetCode50 = new LeetCode50();
        System.out.println(leetCode50.myPow1(x, n));
    }

    /**
     * 方法一：暴力法
     * @param x
     * @param n
     * @return double
     */
    public double myPow1(double x, int n) {
        if (x == 0 || x == 1){ return x; }

        long n2 = n;
        if (n2 < 0){
            x = 1 / x;
            n2 = -n2;
        }

        double ans = 1;
        for (int i = 0; i < n2; i++) {
            ans = ans * x;
        }

        return ans;
    }

    /**
     * 方法二：分治思想的递归实现
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n){
        if (x == 0 || x == 1){ return x; }
        long N = n;
        if (N < 0){
            x = 1 / x;
            N = -N;
        }
        return helper1(x, N);
    }

    public double helper1(double x, long n){
        if (n == 0) { return 1; }

        double y = helper1(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 方法三：分治思想的迭代实现
     * @param x
     * @param n
     * @return
     */
    public double myPow3(double x, int n){
        if (x == 0 || x == 1){ return x; }
        long N = n;
        if (N < 0){
            x = 1 / x;
            N = -N;
        }
        return helper2(x, N);
    }

    public double helper2(double x, long n){
        double ans = 1.0;
        // 贡献的初始值为 x
//        double xi = x;
        // 在对 N 进行二进制拆分的同时计算答案
//        while (n > 0) {
//            if (n % 2 == 1) {
//                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
//                ans *= xi;
//            }
//            // 将贡献不断地平方
//            xi *= xi;
//            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
//            n /= 2;
//        }
        while (n > 0){
            // 奇数次幂
            if (n % 2 == 1){
                ans *= x;
            }
            x *= x;
            n /= 2;
        }
        return ans;
    }
}
