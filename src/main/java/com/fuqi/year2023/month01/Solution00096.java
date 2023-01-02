package com.fuqi.year2023.month01;

/**
 * @author FuQi
 * @date 2023/1/2 21:36
 * @description 不同的二叉搜索树
 */
public class Solution00096 {
    /**
     * 卡特兰数的实现
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution00096 solution00096 = new Solution00096();
        int n = 5;
        System.out.println(solution00096.numTrees(5));
    }
}
