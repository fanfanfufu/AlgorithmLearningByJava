package com.fuqi.year2022.month12;

/**
 * @author FuQi
 * @date 2022/12/16 22:10
 * @description
 */
public class Offer62 {
    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n+1; i++) {
            f = (m+f) % i;
        }

        return f;
    }
}
