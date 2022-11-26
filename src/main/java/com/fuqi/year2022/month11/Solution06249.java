package com.fuqi.year2022.month11;

/**
 * @author FuQi
 * @date 2022/11/26 22:51
 * @description
 */
public class Solution06249 {
    public int numberOfCuts(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return n / 2;
        }

        return n;
    }
}
