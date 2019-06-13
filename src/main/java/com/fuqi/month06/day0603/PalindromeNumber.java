package com.fuqi.month06.day0603;

/**
 * @Description: 回文数
 * @Author 傅琦
 * @Date 2019/6/3 16:26
 * @Version V1.0
 */
public class PalindromeNumber {
    public static void main(String[] args){
        System.out.println("single number mod: " + (11 % 10));
        boolean result = isPalindrome(111);
        System.out.println(result);
    }

    private static boolean isPalindrome(int x){
        if (x < 0){ return false; }
        int y = 0, z = x;
        while (z != 0){
            y = y * 10 + z % 10;
            z /= 10;
        }

        return y == x;
    }
}
