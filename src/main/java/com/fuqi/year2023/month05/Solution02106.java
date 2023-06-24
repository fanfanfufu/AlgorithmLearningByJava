package com.fuqi.year2023.month05;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/4 21:14
 * @description
 */
public class Solution02106 {
    private int loweBound(int[][] fruits, int target) {
        int left = -1, right = fruits.length;
        while (left + 1 < right) {
            int mid = (left+right) >>> 1;
            if (fruits[mid][0] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = loweBound(fruits, startPos-k);
        int right = left, s = 0, n = fruits.length;
        // 从 fruits[left][0] 到 startPos 的水果数
        for (; right < n && fruits[right][0] <= startPos; right++)
            s += fruits[right][1];
        int ans = s;
        for (; right < n && fruits[right][0] <= startPos + k; right++) {
            s += fruits[right][1]; // 枚举最右位置为 fruits[right][0]
            while (fruits[right][0] * 2 - fruits[left][0] - startPos > k &&
                    fruits[right][0] - fruits[left][0] * 2 + startPos > k)
                s -= fruits[left++][1]; // fruits[left][0] 无法到达
            ans = Math.max(ans, s); // 更新答案最大值
        }
        return ans;
    }
}
