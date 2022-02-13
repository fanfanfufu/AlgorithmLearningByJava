package com.fuqi.year2022.month02;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/2/13 16:03
 * @description 岛屿数量
 */
public class Solution00200 {
    private int[] dx = new int[]{1,0,-1,0};
    private int[] dy = new int[]{0,-1,0,1};

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // BFS
                    bfs(grid, i, j);
                    // DFS
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void bfs(char[][] grid, int i, int j) {
        Deque<int[]> neighbors = new LinkedList<>();
        neighbors.offerLast(new int[]{i, j});
        while (!neighbors.isEmpty()) {
            int[] cell = neighbors.pollFirst();
            int x = cell[0], y = cell[1];
            if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == '0') {
                continue;
            }
            // 将已经访问的位置置为0
            grid[x][y] = '0';
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                neighbors.offer(new int[]{nx, ny});
            }
        }
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            dfs(grid, i+dx[k], j+dy[k]);
        }
    }
}
