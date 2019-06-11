package com.fuqi.day0521;

/**
 * @Description: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @Author 傅琦
 * @Date 2019/5/21 22:00
 * @Version V1.0
 */
public class SumSolution {

    public static void main(String[] args){
        SumSolution solution = new SumSolution();
        int result = solution.Sum_Solution(10);
        System.out.println(result);
    }

    public int Sum_Solution(int n) {
        if(n < 1){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return n + Sum_Solution(n-1);
    }
}
