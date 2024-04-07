package com.fuqi.year2024.month04;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/4/7 17:29
 * @description
 */
public class Solution00452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (Comparator.comparingInt(o -> o[1])));
        int preRight = points[0][1];
        int ans = 1;
        for (int[] cur : points) {
            if (cur[0] > preRight) {
                ans++;
                preRight = cur[1];
            }
        }

        return ans;
    }
}
