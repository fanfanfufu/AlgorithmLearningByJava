package com.fuqi.year2023.month02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FuQi
 * @date 2023/2/12 16:41
 * @description 子字符串异或查询
 */
public class Solution06356 {
    /**
     * 把等式 val⊕first=second 两边同时异或 first，
     * 得到val⊕first⊕first=second⊕first
     * 由于 first⊕first=0，因此上式化简为val=second⊕first
     * 所以问题等价于在 s 中找到值为 second⊕first的数。
     *
     * @param s
     * @param queries
     * @return
     */
    public static final int[] NOT_FOUND = {-1, -1};

    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer, int[]> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int bound = Math.min(len, i+30);
            for (int j = i; j < bound; j++) {
                int key = Integer.parseInt(s.substring(i, j + 1), 2);
                int[] val = map.get(key);
                if (val == null || (j-i) < (val[1]-val[0])) {
                    map.put(key, new int[]{i, j});
                }
            }
        }

        int m = queries.length;
        int[][] ans = new int[m][2];
        for (int i = 0; i < m; i++) {
            ans[i] = map.getOrDefault(queries[i][0] ^ queries[i][1], NOT_FOUND);
        }

        return ans;
    }
}
