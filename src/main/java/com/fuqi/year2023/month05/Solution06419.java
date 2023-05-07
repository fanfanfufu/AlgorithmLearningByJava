package com.fuqi.year2023.month05;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/7 15:35
 * @description
 */
public class Solution06419 {
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        if (n == 1) return ans;
        // 从叶子节点开始计算
        int i = n-1;
        while (i > 1) {
            // 计算当前两个叶子节点的差值，即最小修改次数
            // 累加到结果上
            ans += Math.abs(cost[i] - cost[i-1]);
            // 将叶子的最高代价（修改后两个叶子的代价相同）累加到父节点上
            cost[i/2 - 1] += Math.max(cost[i], cost[i-1]);
            // i减2，移动至同一层左边的叶子中，或者移动到上一层的非叶子节点中
            i -= 2;
        }

        return ans;
    }
}
