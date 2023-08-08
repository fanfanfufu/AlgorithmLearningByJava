package com.fuqi.year2023.month08;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/8 21:36
 * @description 1749. 任意子数组和的绝对值的最大值
 */
public class Solution01749 {
    /**
     * 参考第53题，增加变量记录累计的和的最小值
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        if (n == 1) return Math.abs(nums[0]);
        int posSum = 0, posMax = nums[0];
        int negSum = 0, negMin = nums[0];
        for (int num : nums) {
            // 找到正数的最大值
            posSum = Math.max(posSum + num, num);
            posMax = Math.max(posMax, posSum);
            // 找到负数的最小值
            negSum = Math.min(negSum + num, num);
            negMin = Math.min(negMin, negSum);
        }

        return Math.max(posMax, -negMin);
    }
}
