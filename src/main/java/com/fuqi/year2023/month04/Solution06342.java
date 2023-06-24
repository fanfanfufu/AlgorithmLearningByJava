package com.fuqi.year2023.month04;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/30 16:08
 * @description
 */
public class Solution06342 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // cr和cc分别用于记录行和列已经被涂色的格子个数
        int[] cr = new int[m], cc = new int[n];
        // map用于记录每个点的位置
        int[][] map = new int[m * n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[mat[i][j] - 1][0] = i;
                map[mat[i][j] - 1][1] = j;
            }
        }

        // 遍历涂色数组
        for (int i = 0; i < arr.length; i++) {
            // 将对应值所在的坐标的行的染色块个数累加
            cr[map[arr[i] - 1][0]] += 1;
            // 将对应值所在的坐标的列的染色块个数累加
            cc[map[arr[i] - 1][1]] += 1;
            // 判断所在的行或者列是否被填满
            if (cr[map[arr[i]-1][0]] == n || cc[map[arr[i]-1][1]] == m) {
                // 如果是，则返回染色数组当前元素的下标
                return i;
            }
        }

        return -1;
    }
}
