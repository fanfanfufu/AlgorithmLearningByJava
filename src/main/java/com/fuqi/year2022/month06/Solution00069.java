package com.fuqi.year2022.month06;

/**
 * @author FuQi
 * @date 2022/6/22 21:44
 * @description x的平方根，采用二分法
 */
public class Solution00069 {
    public int mySqrt(int x) {
        if (x < 0) {
            return 0;
        }
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 0, right = x, ans = -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid > x) {
                right = mid;
            } else {
                left = mid+1;
                ans = mid;
            }
        }

        return ans;
    }

    /**
     * 牛顿迭代法
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x < 0) {
            return 0;
        }
        if (x == 0 || x == 1) {
            return x;
        }
        double x0 = x;
        while (true) {
            double xi = (x0 + x/x0) * 0.5;
            if ((x0-xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }

        return (int) x0;
    }
}
