package com.fuqi.year2023.month03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/3/30 21:34
 * @description 两点之间不包含任何点的最宽垂直区域
 */
public class Solution01637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        for (int i = 1; i < points.length; i++) ans = Math.max(ans, points[i][0]-points[i-1][0]);

        return ans;
    }
}
