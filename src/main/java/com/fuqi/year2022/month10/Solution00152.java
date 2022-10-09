package com.fuqi.year2022.month10;

/**
 * @author FuQi
 * @date 2022/10/9 22:46
 * @description
 */
public class Solution00152 {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            if (num < 0) {
                // 遇到负数时，最大最小值需要调换
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(max, imax);
        }

        return max;
    }
}
