package com.fuqi.year2024.month04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/4/13 15:35
 * @description
 */
public class Solution02924 {
    public int findChampion(int n, int[][] edges) {
        // 邻接表：每个点存储比所有自己强的队伍（点）
        Set<Integer>[] table = new HashSet[n];
        // 初始化数据
        for (int i = 0; i < n; i++) table[i] = new HashSet<>();
        // 遍历有向边表
        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1];
            table[dest].add(src);
        }
        int ans = -1, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (table[i].isEmpty()) {
                cnt++;
                ans = i;
            }
            if (cnt > 1) return -1;
        }

        return cnt == 0 ? -1 : ans;
    }

    public int findChampion2(int n, int[][] edges) {
        int[] degree = new int[n];
        for (int[] e : edges) {
            degree[e[1]]++;
        }
        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                if (champion == -1) {
                    champion = i;
                } else {
                    return -1;
                }
            }
        }
        return champion;
    }
}
