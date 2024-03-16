package com.fuqi.year2024.month03;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/3/16 15:05
 * @description
 */
public class Solution02684 {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Integer> q = new HashSet<>();
        for (int i = 0; i < m; i++) {
            q.add(i);
        }
        for (int j = 1; j < n; j++) {
            Set<Integer> q2 = new HashSet<>();
            for (int i : q) {
                for (int i2 = i - 1; i2 <= i + 1; i2++) {
                    if (0 <= i2 && i2 < m && grid[i][j - 1] < grid[i2][j]) {
                        q2.add(i2);
                    }
                }
            }
            q = q2;
            if (q.isEmpty()) {
                return j - 1;
            }
        }
        return n - 1;
    }
}
