package com.fuqi.month06.day0603;

/**
 * @Description: 将有符号int型数据的值反转
 * @Author 傅琦
 * @Date 2019/6/3 8:58
 * @Version V1.0
 */
public class ReverseInteger {
    public static void main(String[] args){
        int result = reverse(1534236469);
        System.out.println(result);
    }

    public static int reverse(int x) {
        long res = 0L;
        while (x != 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            return 0;
        }else {
            return (int) res;
        }
    }
}
