package com.fuqi.month06.day0616;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description:
 * @Team: 电子科技大学自动化研究所
 * @Author: 傅琦
 * @DateTime: 2019/6/16 11:23
 * @Version: V1.0
 */
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        // [[0,0,1,0,0,0,0],[0,1,0,0,0,0,1],[0,0,1,0,1,0,0],[0,0,0,1,1,1,0],[1,0,0,1,1,0,0],[1,1,1,1,1,0,1],[0,0,1,0,0,0,0]]
        int[][] input = new int[][]{{0,0,1,0,0,0,0}, {0,1,0,0,0,0,1}, {0,0,1,0,1,0,0}, {0,0,0,1,1,1,0}, {1,0,0,1,1,0,0},
                {1,1,1,1,1,0,1}, {0,0,1,0,0,0,0}};
        ShortestPathInBinaryMatrix matrix = new ShortestPathInBinaryMatrix();
        int res = matrix.shortestPathBinaryMatrix(input);
        System.out.println(res);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        if (grid[0][0] == 1){
            return -1;
        }

        dp[0][0] = 1;

        for (int i = 1; i < grid.length; i++) {
            if (grid[i][0] == 0){
                dp[i][0] = dp[i-1][0] + 1;
            }else {
                break;
            }
        }

        for (int j = 1; j < grid[0].length; j++) {
            if (grid[0][j] == 0){
                dp[0][j] = dp[0][j-1] + 1;
            }else {
                break;
            }
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    if (j == grid[0].length-1) {
                        Queue<Integer> queue = new PriorityQueue<>();
                        queue.offer(dp[i][j-1]);
                        queue.offer(dp[i-1][j-1]);
                        queue.offer(dp[i-1][j]);
                        while (!queue.isEmpty()){
                            if (queue.peek() != 0){
                                dp[i][j] = queue.poll() + 1;
                                break;
                            }else {
                                queue.poll();
                            }
                        }
                    }else {
                        Queue<Integer> queue = new PriorityQueue<>();
                        queue.offer(dp[i][j-1]);
                        queue.offer(dp[i-1][j-1]);
                        queue.offer(dp[i-1][j]);
                        queue.offer(dp[i-1][j+1]);
                        while (!queue.isEmpty()){
                            if (queue.peek() != 0){
                                dp[i][j] = queue.poll() + 1;
                                break;
                            }else {
                                queue.poll();
                            }
                        }
                    }
                }
            }
        }

        return dp[grid.length-1][grid[0].length-1] > 0 ? dp[grid.length-1][grid[0].length-1] : -1;
    }
}
