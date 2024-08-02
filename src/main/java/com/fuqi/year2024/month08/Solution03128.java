package com.fuqi.year2024.month08;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/8/2 23:52
 * @description
 */
public class Solution03128 {
    public long numberOfRightTriangles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] col = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                col[j] += grid[i][j];
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            int row = Arrays.stream(grid[i]).sum();
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    res += (row - 1) * (col[j] - 1);
                }
            }
        }
        return res;
    }
}
