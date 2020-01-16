package com.fuqi.year2019.month10;

/**
 * @Description: 给定一个 方形 整数数组 A，我们想要得到通过 A 的下降路径的最小和
 * @Author 傅琦
 * @date 2019/10/19 15:27
 * @Version V1.0
 */
public class LeetCode931 {
    public static int minFallingPathSum(int[][] A) {
        int len = A.length;
        if (len == 0) { return 0; }

        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[0][i] = A[0][i];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j == 0){
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }else if (j == len - 1){
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }else {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            ans = ans < dp[len-1][i] ? ans : dp[len-1][i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
        int res = minFallingPathSum(arr);
        System.out.println(res);
    }
}
