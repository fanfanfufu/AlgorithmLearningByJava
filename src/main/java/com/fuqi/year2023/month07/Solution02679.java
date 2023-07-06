package com.fuqi.year2023.month07;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/4 20:57
 * @description
 */
public class Solution02679 {
    public int matrixSum(int[][] nums) {
        // 1 按行遍历矩阵，对每行进行排序
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        // 2 遍历排序后的矩阵，计算分数之和
        int ans = 0;
        for (int j = 0; j < nums[0].length; j++) {
            int colMax = 0;
            for (int i = 0; i < nums.length; i++) {
                colMax = Math.max(colMax, nums[i][j]);
            }
            ans += colMax;
        }

        return ans;
    }
}
