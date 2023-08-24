package com.fuqi.year2023.month08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/24 23:05
 * @description
 */
public class Solution01267 {

    /**
     * 两次遍历，只不过第二次只是遍历第一次出现的服务器的坐标，判断第一次出现的服务器是否需要算到结果中
     *
     * @param grid
     * @return
     */
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        if (m == 1 && n == 1) return ans;
        // 记录当前行是否有计算机
        int[] row = new int[m];
        // 记录当前列是否有计算机
        int[] col = new int[n];
        List<int[]> firstPos = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                // 如果当前位置有服务器
                if (row[i] == 0 && col[j] == 0) {
                    // 第一次出现服务器
                    row[i] = 1;
                    col[j] = 1;
                    firstPos.add(new int[]{i, j});
                    continue;
                }
                // 并且其所在的行或者列已经存在服务器了，则结果+1
                if (row[i] > 0 || col[j] > 0) {
                    ans++;
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for (int[] pos : firstPos) {
            if (row[pos[0]] > 0 || col[pos[1]] > 0) ans++;
        }

        return ans;
    }
}
