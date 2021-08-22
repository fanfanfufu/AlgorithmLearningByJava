package com.fuqi.year2021.month08.day20210822;

/**
 * @author FuQi
 */
public class Solution3 {
    public static int minimizeTheDifference1(int[][] mat, int target) {
        // 初始化dp数组
        boolean[][] dp=new boolean[mat.length+1][4900];
        dp[0][0]=true;

        for(int i=1;i<=mat.length;i++){
            for(int j=0;j<4900;j++){
                for(int k=0;k<mat[i].length;k++){
                    if(j-mat[i-1][k]>=0 && dp[i - 1][j - mat[i - 1][k]]){
                        dp[i][j]=true;
                        break;
                    }
                    dp[i][j]=false;
                }
            }
        }
        int ret=Integer.MAX_VALUE;
        for(int j=0;j<4900;j++){
            if(dp[mat.length][j]){
                ret=Math.min(Math.abs(target-j),ret);
            }
        }
        return ret;
    }

    public static int minimizeTheDifference(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        int limit = 70 * 70;
        boolean[][] dp = new boolean[n][limit];
        for (int i = 0; i < m; i++) {
            dp[0][mat[0][i]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int s = 0; s < limit; s++) {
                if (!dp[i-1][s]) {
                    continue;
                }
                for (int j = 0; j < m; j++) {
                    int sum = s + mat[i][j];
                    if (sum >= limit) {
                        continue;
                    }
                    dp[i][sum] = true;
                }
            }
        }

        int ans = limit + 5;
        for (int i = 0; i < limit; i++) {
            if (dp[n-1][i]) {
                ans = Math.min(ans, Math.abs(target - i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int target = 13;
//        int res = minimizeTheDifference1(mat, target);
        int res = minimizeTheDifference(mat, target);
        System.out.println("res = " + res);
    }
}
