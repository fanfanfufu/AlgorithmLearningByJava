package com.fuqi.year2023.month01;

/**
 * @author FuQi
 * @date 2023/1/11 21:38
 * @description
 */
public class Solution00400 {
    public int findNthDigit(int n) {
        int len = 1;
        while (len * 9 * Math.pow(10, len- 1) < n) {
            n -= len * 9 * Math.pow(10, len-1);
            len++;
        }
        long s = (long) Math.pow(10, len-1);
        long x = n / len - 1 + s;
        n -= (x - s + 1) * len;
        return n == 0 ? (int) (x % 10) : (int) ((x+1) / Math.pow(10, len-n) % 10);
    }
}
