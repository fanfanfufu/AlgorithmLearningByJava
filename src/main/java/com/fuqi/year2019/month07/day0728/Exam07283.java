package com.fuqi.year2019.month07.day0728;

/**
 * @Description: 第三题——最大以1为边界的正方形
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。
 * 如果不存在，则返回 0。
 *
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：9
 *
 * 输入：grid = [[1,1,0,0]]
 * 输出：1
 *
 * @Author 傅琦
 * @date 2019/7/28 10:27
 * @Version V1.0
 */
public class Exam07283 {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0){
                    dp[i][j] = 0;
                }else {

                }
            }
        }
        return 0;
    }
}
