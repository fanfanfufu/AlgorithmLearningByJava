package com.fuqi.year2022.month11;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2022/11/26 23:16
 * @description
 */
public class Solution06277 {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;;
        int n = grid[0].length;
        int[][] onesRow = new int[m][n];
        int[][] onesCol = new int[m][n];
        int[][] zerosRow = new int[m][n];
        int[][] zerosCol = new int[m][n];

        int [][] diff = new int[m][n];

        // 遍历设值
        // 将行的数据计算好
        for (int i = 0; i < m; i++) {
            int[] row = grid[i];
            int ones = 0;
            int zeros = 0;
            for (int j = 0; j < row.length; j++) {
                if (grid[i][j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
            }
            Arrays.fill(onesRow[i], ones);
            Arrays.fill(zerosRow[i], zeros);
        }
        // 按列统计数据
        for (int i = 0; i < n; i++) {
            int ones = 0;
            int zeros = 0;
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int j = 0; j < m; j++) {
                zerosCol[j][i] = zeros;
                onesCol[j][i] = ones;
            }
        }

        // 计算diff元素的值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = onesRow[i][j] + onesCol[i][j] - zerosRow[i][j] - zerosCol[i][j];
            }
        }

        return diff;
    }
}
