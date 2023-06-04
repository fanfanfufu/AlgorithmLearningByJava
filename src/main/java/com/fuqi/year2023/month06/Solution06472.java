package com.fuqi.year2023.month06;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/4 16:00
 * @description
 */
public class Solution06472 {
    public long matrixSumQueries(int n, int[][] queries) {
        long ans = 0;
        Set<Integer> row_used = new HashSet<>();
        Set<Integer> col_used = new HashSet<>();
        for (int i = queries.length-1; i >= 0; i--) {
            int type = queries[i][0], index = queries[i][1], val = queries[i][2];
            if (type == 0) {
                if (row_used.contains(index)) continue;
                ans += (long) (n - col_used.size()) * val;
                row_used.add(index);
            } else {
                if (col_used.contains(index)) continue;
                ans += (long) (n - row_used.size()) * val;
                col_used.add(index);
            }
        }

        return ans;
    }
}
