package com.fuqi.year2023.month09;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/9/7 23:26
 * @description
 */
public class Solution02594 {
    public long repairCars(int[] ranks, int cars) {
        long left = 1, right = (long) ranks[0] * cars * cars;
        while (left < right) {
            long mid = (left + right) >> 1;
            if (check(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean check(int[] ranks, int cars, long mid) {
        double cnt = 0;
        for (int rank : ranks) {
            cnt += Math.sqrt(mid / rank);
        }

        return cnt >= cars;
    }
}
