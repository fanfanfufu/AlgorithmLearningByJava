package com.fuqi.year2023.month12;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/12/19 22:00
 * @description
 */
public class Solution01901 {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int low = 0, high = m - 1;
        while (low <= high) {
            int i = (low + high) / 2;
            int j = -1, maxElement = -1;
            // 遍历当前第i行，找到这一行的最大值，及其所在的列的索引
            for (int k = 0; k < n; k++) {
                if (mat[i][k] > maxElement) {
                    j = k;
                    maxElement = mat[i][k];
                }
            }
            if (i >= 1 && mat[j][j] < mat[i - 1][j]) {
                high = i - 1;
                continue;
            }
            if (i + 1 < m && mat[i][j] < mat[i + 1][j]) {
                low = i + 1;
                continue;
            }

            return new int[]{i, j};
        }

        return new int[0];
    }
}
