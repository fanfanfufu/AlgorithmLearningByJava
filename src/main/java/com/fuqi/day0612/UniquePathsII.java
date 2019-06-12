package com.fuqi.day0612;

/**
 * @Description: 路径计算2：加入了障碍格子
 * @Author 傅琦
 * @Date 2019/6/12 10:42
 * @Version V1.0
 */
public class UniquePathsII {
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1){
            return 0;
        }

        dp[0][0] = 1;
        // 先遍历第一行和第一列，这里能有些许性能上的优化
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1){
                break;
            }else {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int j = 1; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1){
                break;
            }else {
                dp[0][j] = dp[0][j-1];
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                // 此题与前一道题不一样的地方在于，要判断当前位置否为为障碍点
                // 若是，则路径数置为0；不是的话则路径数为上方与左边的路径数之和
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args){
        int[][] input = {{0,0,0}, {0,1,0}, {0,0,1}};
        int res = uniquePathsWithObstacles(input);
        System.out.print(res);
    }
}
