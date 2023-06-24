package com.fuqi.year2023.month05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/15 22:36
 * @description 按列翻转得到最大值等行数
 */
public class Solution01072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '0');
            for (int j = 0; j < n; j++) {
                row[j] = (char) ('0' + (matrix[i][j] ^ matrix[i][0]));
            }
            String s = new String(row);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans = Math.max(ans, entry.getValue());
        }

        return ans;
    }
}
