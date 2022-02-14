package com.fuqi.year2022.month02;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/2/14 23:25
 * @description
 */
public class Solution01091 {
    private int[] dx = new int[]{1,1,0,-1,-1,-1,0,1};
    private int[] dy = new int[]{0,1,1,1,0,-1,-1,-1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1) {
            // 左顶点为1，则直接没有路径
            return -1;
        }
        Deque<int[]> deque = new LinkedList<>();
        // 将左顶点坐标以及步数放入队列中
        deque.offerLast(new int[]{0,0,1});
        // 将已经访问的左顶点置为1
        grid[0][0] = 1;
        while (!deque.isEmpty()) {
            int[] cell = deque.pollFirst();
            if (cell[0] == m-1 && cell[1] == n-1) {
                // 特殊情况，只有一个0的情况，
                return cell[2];
            }
            for (int i = 0; i < 8; i++) {
                int x = cell[0] + dx[i];
                int y = cell[1] + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                    deque.offerLast(new int[]{x, y, cell[2]+1});
                    // 访问过后置为1
                    grid[x][y] = 1;
                }
            }
        }

        return -1;
    }
}
