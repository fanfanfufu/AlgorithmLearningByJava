package com.fuqi.year2021.month08.day20210830;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author FuQi
 * @Desc 岛屿的最大面积
 */
public class Solution00695 {
    private int[] dx = new int[]{1,0,-1,0};
    private int[] dy = new int[]{0,-1,0,1};

    /**
     * BFS
     * @param grid
     * @return
     */
    public int maxAreaOfIsland1(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = 0;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i,j});

                while (!queue.isEmpty()) {
                    int[] cell = queue.poll();
                    int x = cell[0], y = cell[1];
                    if (x < 0 || y < 0 || x == n || y == m || grid[x][y] == 0) {
                        continue;
                    }
                    cur++;
                    // 将已经访问过的置为0，防止重复计算
                    grid[x][y] = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k], ny = y + dy[k];
                        queue.offer(new int[]{nx, ny});
                    }
                }

                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    /**
     * DFS
     * @param grid
     * @return
     */
    public int maxAreaOfIsland2(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int cur_i, int cur_j) {
        // dfs方法需要首先对入参进行校验, 也是递归的终止条件
        if (cur_i < 0 || cur_j < 0 || cur_i >= grid.length || cur_j >= grid[0].length || grid[cur_i][cur_j] == 0) {
            return 0;
        }
        // 能通过终止条件说明grid[cur_i][cur_j] == 1
        int ans = 1;
        // 为了避免重复访问，将访问过的位置的值都改为0
        grid[cur_i][cur_j] = 0;
        for(int i = 0; i < 4; i++) {
            ans += dfs(grid, cur_i+dx[i], cur_j+dy[i]);
        }

        return ans;
    }
}
