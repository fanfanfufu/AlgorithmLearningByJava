package com.fuqi.year2023.month08;

import java.util.Arrays;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/19 23:03
 * @description
 */
public class Solution06941 {
    public int minimumOperations1(List<Integer> nums) {
        //动态规划
        //dp[i][j] 为：右边界结尾nums[i]==j的小操作，三路动态规划\
        //状态转移方程：
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = nums.get(i) - 1;
        }

        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 10);
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = (arr[0] == i) ? 0 : 1;
        }

        for (int i = 1; i < n; i++) {
            int v = arr[i];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + (v == j ? 0 : 1));
                }
            }
        }

        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }


    public int minimumOperations2(List<Integer> nums) {
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = nums.get(i) - 1;
        }
        int[][] dp = new int[n+1][4];

        for (int i = 1; i <= n; i++) {
            if (arr[i-1] == 1) {
                dp[i][1] = dp[i-1][1];
                // 当前位置需要修改为2，因此结果需要+1
                dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + 1;
                dp[i][3] = Math.min(dp[i-1][1], Math.min(dp[i-1][2], dp[i-1][3])) + 1;
            } else if (arr[i-1] == 2) {
                // 当前位置本来是2，需要变成1的话，就需要在前面以1结尾的结果的基础上+1
                dp[i][1] = dp[i-1][1] + 1;
                dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][3] = Math.min(dp[i-1][1], Math.min(dp[i-1][2], dp[i-1][3])) + 1;
            } else {
                dp[i][1] = dp[i-1][1] + 1;
                dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + 1;
                dp[i][3] = Math.min(dp[i-1][1], Math.min(dp[i-1][2], dp[i-1][3]));
            }
        }

        int ans = 1000;
        for (int i = 1; i < 4; i++) {
            ans = Math.min(dp[n][i], ans);
        }

        return ans;
    }
}
