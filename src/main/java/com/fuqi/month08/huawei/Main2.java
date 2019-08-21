package com.fuqi.month08.huawei;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/21 18:59
 * @Version V1.0
 */
public class Main2 {
    private static List<Integer> helper(long min, long max) {
        List<Integer> prime = new LinkedList<>();
        boolean[] isPrime = new boolean[(int) max+1];
        isPrime[0] = true;
        isPrime[1] = true;
        boolean flag = true;
        for (int i = 2; i <= max; i++) {
            flag = true;
            for (int j = 2; j*j <= i; j++) {
                if (i % j == 0){
                    isPrime[i] = true;
                    flag = false;
                    break;
                }
            }

            if (flag) {
                if (min <= i && i < max) {
                    prime.add(i);
                    isPrime[i] = false;
                }
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long low = scanner.nextLong();
        long high = scanner.nextLong();

        List<Integer> ans = helper(low, high);

        long bitTen = 0;
        long bitNum = 0;
        for (int num : ans) {
            String str = String.valueOf(num);
            if (str.length() < 2) {
                bitNum += num;
            }else {
                bitTen += str.charAt(str.length() - 2) - '0';
                bitNum += str.charAt(str.length() - 1) - '0';
            }
        }

        System.out.println(Math.min(bitTen, bitNum));

        scanner.close();
    }
}
