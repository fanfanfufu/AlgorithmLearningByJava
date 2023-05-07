package com.fuqi.year2023.month05;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/7 15:22
 * @description
 */
public class Solution06418 {
    public int[] colorTheArray(int n, int[][] queries) {
        int len = queries.length, cnt = 0;
        int[] ans = new int[len], a = new int[n+2];
        for (int i = 0; i < len; i++) {
            int x = queries[i][0]+1, color = queries[i][1];
            if (a[x] > 0) cnt -= (a[x] == a[x-1] ? 1 : 0) + (a[x] == a[x+1] ? 1 : 0);
            a[x] = color;
            cnt += (a[x] == a[x-1] ? 1 : 0) + (a[x] == a[x+1] ? 1 : 0);
            ans[i] = cnt;
        }

        return ans;
    }
}
