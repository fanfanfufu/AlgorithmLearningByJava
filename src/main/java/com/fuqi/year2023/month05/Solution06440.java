package com.fuqi.year2023.month05;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/28 10:46
 * @description
 */
public class Solution06440 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 对角线元素的共同点：行坐标值 - 列坐标值 = 固定值
                // 统计左对角线上的不同值
                Set<Integer> topLeft = new HashSet<>();
                for (int k = 1; k < n; k++) {
                    int tlr = i-k, tlc = j-k;
                    if (tlr < 0 || tlc < 0) break;
                    topLeft.add(grid[tlr][tlc]);
                }
                // 统计右对角线上的不同值
                Set<Integer> bottomRight = new HashSet<>();
                for (int k = 1; k < n; k++) {
                    int brr = i+k, brc = j+k;
                    if (brr == m || brc == n) break;
                    bottomRight.add(grid[brr][brc]);
                }

                ans[i][j] = Math.abs(topLeft.size() - bottomRight.size());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution06440 solution06440 = new Solution06440();
        int[][] grid = {{1,2,3},{3,1,5},{3,2,1}};
        solution06440.differenceOfDistinctValues(grid);
    }
}
