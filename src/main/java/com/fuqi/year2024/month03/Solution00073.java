package com.fuqi.year2024.month03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/3/10 20:57
 * @description
 */
public class Solution00073 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> zeroCells = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) zeroCells.add(new int[]{i, j});
            }
        }
        for (int[] cell : zeroCells) {
            int x = cell[0], y = cell[1];
            // fill the raw with the zero cell
            Arrays.fill(matrix[x], 0);
            // fill the column with the zero cell
            for (int i = 0; i < m; i++) matrix[i][y] = 0;
        }
    }
}
