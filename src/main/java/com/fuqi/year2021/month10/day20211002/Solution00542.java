package com.fuqi.year2021.month10.day20211002;

import java.util.*;

/**
 * @author FuQi
 * @date 2021/10/2 10:15
 * @description 542-01矩阵
 */
public class Solution00542 {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    /**
     * 广度优先搜索
     * 将所有0看作是一个整体, 1距离最近0的距离相当于到所有0的距离
     *
     * @param mat
     * @return
     */
    public int[][] updateMatrix1(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] ans = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> deque = new LinkedList<>();
        // 1. 遍历矩阵找出所有0节点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    deque.offer(new int[]{i, j});
                    ans[i][j] = 0;
                }
            }
        }
        // 对剩余1节点进行遍历
        while (!deque.isEmpty()) {
            int[] point = deque.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = x + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    ans[nx][ny] = ans[x][y] + 1;
                    deque.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return ans;
    }

    /**
     * 动态规划:
     * f(x,y) = min(f(x-1, y), f(x, y-1))+1
     * f(x,y) = min(f(x-1, y), f(x, y+1))+1
     * f(x,y) = min(f(x+1, y), f(x, y-1))+1
     * f(x,y) = min(f(x+1, y), f(x, y+1))+1
     *
     * 四种情况则遍历四次,最终可得到最小距离矩阵
     * @param mat
     * @return
     */
    public int[][] updateMatrix2(int[][] mat) {
        int n = mat.length, m = mat[0].length, initDist = 10000;
        int[][] ans = new int[n][m];
        // 初始化原始距离
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], initDist);
        }
        // 遍历第一遍, 对0节点的距离设值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                }
            }
        }
        // 对第一种走向进行遍历, ↑和←
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i-1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i-1][j] + 1);
                }
                if (j-1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j-1] + 1);
                }
            }
        }
        // 对第二种走向进行遍历, ↓和←
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (i+1 < n) {
                    ans[i][j] = Math.min(ans[i][j], ans[i+1][j] + 1);
                }
                if (j-1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j-1] + 1);
                }
            }
        }
        // 对第三种走向进行遍历, ↑和→
        for (int i = 0; i < n; i++) {
            for (int j = m-1; j >= 0; j--) {
                if (i-1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i-1][j] + 1);
                }
                if (j+1 < m) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j+1] + 1);
                }
            }
        }

        // 对第四种走向进行遍历, ↓和→
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (i+1 < n) {
                    ans[i][j] = Math.min(ans[i][j], ans[i+1][j] + 1);
                }
                if (j+1 < m) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j+1] + 1);
                }
            }
        }

        return ans;
    }

    /**
     * 方法二优化:
     * 只保留(↑+←)和(↓+→)两种情况的即可
     *
     * @param mat
     * @return
     */
    public int[][] updateMatrix3(int[][] mat) {
        int n = mat.length, m = mat[0].length, initDist = 10000;
        int[][] ans = new int[n][m];
        // 初始化原始距离
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], initDist);
        }
        // 遍历第一遍, 对0节点的距离设值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                }
            }
        }
        // 对第一种走向进行遍历, ↑和←
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i-1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i-1][j] + 1);
                }
                if (j-1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j-1] + 1);
                }
            }
        }
        // 对第四种走向进行遍历, ↓和→
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (i+1 < n) {
                    ans[i][j] = Math.min(ans[i][j], ans[i+1][j] + 1);
                }
                if (j+1 < m) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j+1] + 1);
                }
            }
        }

        return ans;
    }
}
