package com.fuqi.day0612;

/**
 * @Description: 一个m*n的网格中，从左上顶点出发，要达到右下顶点，求出不同路径的总数
 * 样例1：
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * 样例2：
 * Input: m = 7, n = 3
 * Output: 28
 *
 * @Author 傅琦
 * @Date 2019/6/12 9:59
 * @Version V1.0
 */
public class UniquePaths {
    private static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0){ return 0; }

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 若当前位置位于第一行或者第一列，到达当前位置只有1条路经
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                }else {
                    // 若当前位置位于其余位置
                    // 则到达当前位置的路径为到达其上方的路径数与到达其左边的路径数的和
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }

    public static void main(String[] args){
        int col = 3;
        int raw = 2;
        int res = uniquePaths(col, raw);
        System.out.print(res);
    }
}
