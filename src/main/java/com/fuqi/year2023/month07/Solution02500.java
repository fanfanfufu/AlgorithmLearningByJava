package com.fuqi.year2023.month07;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/27 20:36
 * @description
 */
public class Solution02500 {
    public int deleteGreatestValue(int[][] grid) {
        if (grid.length == 1) return Arrays.stream(grid[0]).sum();
        for (int[] row : grid) Arrays.sort(row);
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int j = n-1; j >= 0; j--) {
            int colMax = 0;
            for (int[] ints : grid) colMax = Math.max(colMax, ints[j]);
            ans += colMax;
        }

        return ans;
    }
}
