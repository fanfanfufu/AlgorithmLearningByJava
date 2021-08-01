package com.fuqi.year2021.month08.day20210801;

/**
 * @author FuQi
 */
public class Solution1 {
    public static void main(String[] args) {
        int input1 = 2;
        int input2 = 4;
        int input3 = 6;
        int input4 = 8;
        System.out.println(isThree(input1));
        System.out.println(isThree(input2));
        System.out.println(isThree(input3));
        System.out.println(isThree(input4));
    }

    public static boolean isThree(int n) {
        int sqrt =(int) Math.floor(Math.sqrt(n));
        if (n == Math.pow(sqrt, 2)) {
            if (isPrime(sqrt)) {
                return true;
            }
        }
        return false;
    }


    public static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
