package com.fuqi.year2022.month02;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/2/13 16:44
 * @description 省份数量
 */
public class Solution00547 {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, n, i);
                ans++;
            }
        }

        return ans;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int n, int i) {
        for (int j = 0; j < n; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                dfs(isConnected, visited, n, j);
            }
        }
    }

    public int findCircleNumBFS(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                deque.offerLast(i);
                while (!deque.isEmpty()) {
                    int j = deque.pollFirst();
                    visited[j] = true;
                    for (int k = 0; k < n; k++) {
                        if (!visited[k] && isConnected[j][k] == 1) {
                            deque.offerLast(k);
                        }
                    }
                }
                ans++;
            }
        }

        return ans;
    }

    /**
     * 并查集
     *
     * @param parent
     * @param index
     * @return
     */
    private int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }

        return parent[index];
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int findCircleNum3(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < provinces; i++) {
            for (int j = i+1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                ans++;
            }
        }

        return ans;
    }
}
