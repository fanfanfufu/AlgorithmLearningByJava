package com.fuqi.year2023.month08;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/9 22:38
 * @description
 */
public class Solution01281 {
    public int subtractProductAndSum(int n) {
        if (n < 10) return 0;
        int sum = 0, product = 1;
        while (n > 0) {
            int mod = n % 10;
            sum += mod;
            product *= mod;
            n /= 10;
        }

        return product - sum;
    }

    public static void main(String[] args) {
        Solution01281 solution01281 = new Solution01281();
        System.out.println(solution01281.subtractProductAndSum(234));
    }
}
