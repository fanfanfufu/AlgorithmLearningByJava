package com.fuqi.year2019.month08.day0817;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/8/17 10:31
 * @Version: V1.0
 */
public class Solution08171 {
    public boolean isPalindrome(int x) {
        if (x < 0){ return false; }

        int xtemp = x;
        long y = 0;
        int count = -1;

        while (xtemp > 0){
            xtemp /= 10;
            count++;
        }

        xtemp = x;
        while (xtemp > 0){
            int i = xtemp % 10;
            y += i * Math.pow(10, count);
            xtemp /= 10;
            count--;
        }

        return x == y;
    }

    public static void main(String[] args) {
        Solution08171 solution08171 = new Solution08171();
        boolean res = solution08171.isPalindrome(2147483647);
        System.out.println("res = " + res);
    }
}
