package com.fuqi.year2021.month07.day20210710;

public class Solution1 {
    public static int countTriples(int n) {
        int res = 0;
        for (int i = 2; i < n-1; i++) {
            int a = i;
            for (int j = i+1; j < n; j++) {
                int b = j;
                int sum = a*a + b*b;
                int sqrt_res = (int) Math.floor(Math.sqrt(sum));
                if (sqrt_res > n) {
                    break;
                }
                int pow_res = sqrt_res * sqrt_res;
                if (pow_res == sum) {
                    res += 2;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countTriples(250));
    }
}
