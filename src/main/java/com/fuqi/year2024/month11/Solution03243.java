package com.fuqi.year2024.month11;

import java.util.*;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/11/19 22:17
 * @description
 */
public class Solution03243 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            neighbors.get(i).add(i + 1);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            neighbors.get(queries[i][0]).add(queries[i][1]);
            ans[i] = bfs(n, neighbors);
        }

        return ans;
    }

    private int bfs(int n, List<List<Integer>> neighbors) {
        int[] dist = new int[n];
        for (int i = 1; i < n; i++) {
            dist[i] = -1;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : neighbors.get(x)) {
                if (dist[y] >= 0) continue;
                queue.add(y);
                dist[y] = dist[x] + 1;
            }
        }

        return dist[n - 1];
    }
}
