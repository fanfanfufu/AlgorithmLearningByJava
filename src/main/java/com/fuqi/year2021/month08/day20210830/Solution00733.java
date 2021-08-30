package com.fuqi.year2021.month08.day20210830;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author FuQi
 */
public class Solution00733 {

    private int[] dx = new int[]{1,0,-1,0};
    private int[] dy = new int[]{0,-1,0,1};

    /**
     * 广度有限搜索BFS
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {

        int oldColor = image[sr][sc];
        if (oldColor == newColor){
            return image;
        }
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int nextX = x+dx[i], nextY = y+dy[i];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    // 如果下一个点位于image之内
                    if (image[nextX][nextY] == oldColor) {
                        image[nextX][nextY] = newColor;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return image;
    }

    /**
     * 深度有限搜索DFS
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            dfs(image, sr, sc, oldColor, newColor);
        }

        return image;
    }

    private void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        if (image[x][y] != oldColor) {
            return;
        }
        image[x][y] = newColor;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i], nextY = y + dy[i];
            if (nextX >= 0 && nextX < image.length && nextY >= 0 && nextY < image[0].length) {
                dfs(image, nextX, nextY, oldColor, newColor);
            }
        }
    }
}
