package com.fuqi.year2023.month07;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/30 11:43
 * @description
 */
public class Solution00135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;
        int[] leftDp = new int[n];
        // 1 从左往右遍历，记录左边元素满足规则的分糖数目
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) leftDp[i] = leftDp[i - 1] + 1;
            else leftDp[i] = 1;
        }
        // 2 从右往左遍历，计算右边元素满足规则的分糖数目
        int rightDp = 0, ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) rightDp = rightDp + 1;
            else rightDp = 1;
            // 3 累加满足左右两边元素规则的分糖数据
            ans += Math.max(leftDp[i], rightDp);
        }

        return ans;
    }
}
