package com.fuqi.year2019.month07.day0728;

/**
 * @Description: 第一题——第n个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 *
 * 输入：n = 25
 * 输出：1389537
 *
 * @Author 傅琦
 * @date 2019/7/28 10:26
 * @Version V1.0
 */
public class Exam07281 {
    public int tribonacci(int n) {
        if (n == 0){ return 0; }
        if (n == 1 || n == 2){ return 1; }

        int[] record = new int[n+1];

        record[0] = 0;
        record[1] = 1;
        record[2] = 1;
        for (int i = 3; i < record.length; i++) {
            record[i] = record[i-3] + record[i-2] + record[i-1];
        }

        return record[n];
    }

    public static void main(String[] args) {
        Exam07281 exam07281 = new Exam07281();
        int res = exam07281.tribonacci(25);
        System.out.println("res = " + res);
    }
}
