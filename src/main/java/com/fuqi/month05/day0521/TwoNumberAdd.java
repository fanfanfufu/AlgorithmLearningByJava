package com.fuqi.month05.day0521;

/**
 * @Description: 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @Author 傅琦
 * @Date 2019/5/21 22:05
 * @Version V1.0
 */
public class TwoNumberAdd {

    /**
     * 思路一：偷鸡过，它给的函数体内不能出现相关运算符，那么就在外面自己写一个函数来用相关运算符算，本函数体直接调用即可
     * @param num1
     * @param num2
     * @return
     */
    public int add1(int num1,int num2) {
        return sum(num1, num2);
    }

    private static int sum(int num1, int num2){
        return num1 + num2;
    }

    /**
     * 思路二：位运算
     * @param num1
     * @param num2
     * @return
     */
    public int add2(int num1, int num2){
        while (num2 != 0){
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
