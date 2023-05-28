package com.fuqi.year2023.month05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/28 14:41
 * @description
 */
public class Solution06456 {
    public int maxIncreasingCells(int[][] mat) {
        Map<Integer, List<int[]>> map = new TreeMap<>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(mat[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        int ans = 0;
        int[] rowMax = new int[m], colMax = new int[n];
        for (List<int[]> pos : map.values()) {
            int[] mx = new int[pos.size()];
            for (int i = 0; i < pos.size(); i++) {
                mx[i] = Math.max(rowMax[pos.get(i)[0]], colMax[pos.get(i)[1]]) + 1;
                ans = Math.max(ans, mx[i]);
            }

            for (int i = 0; i < pos.size(); i++) {
                int x = pos.get(i)[0], y = pos.get(i)[1];
                rowMax[x] = Math.max(rowMax[x], mx[i]);
                colMax[y] = Math.max(colMax[y], mx[i]);
            }
        }

        return ans;
    }
}
