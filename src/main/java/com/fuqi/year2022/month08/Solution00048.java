package com.fuqi.year2022.month08;

/**
 * @author FuQi
 * @date 2022/8/23 23:34
 * @description 顺时针旋转图像90°
 */
public class Solution00048 {
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

    /**
     * 两次翻转：
     * 1. 先水平翻转
     * 2. 再沿主对角线翻转
     *
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 1.  水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = tmp;
            }
        }
        // 2. 主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
