package com.fuqi.year2019.month08.zijie;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/25 19:47
 * @Version V1.0
 */
public class Main1 {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        char[]c={'a','b','c'};
        // false
        System.out.println(a==b);

        Integer a1 = new Integer(200);
        int b1 = 200;
        // true
        System.out.println(a1 == b1);
    }
}
