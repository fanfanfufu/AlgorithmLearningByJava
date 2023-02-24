package com.fuqi.year2023.month02;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2023/2/18 23:11
 * @description 修改两个元素的最小分数
 */
public class Solution06361 {
    /**
     * 修改两个数：
     * 1. 修改成 nums数组中的任意一个数，则最小的差值为0
     * 2. 剩下找出修改后最大得分最小的即可
     *
     * @param nums
     * @return
     */
    public int minimizeSum(int[] nums) {
        // 先对数组进行排序
        Arrays.sort(nums);
        int len = nums.length;
        // 分类讨论
        // 1. 将最大的数改为与第二大的数相同，最小的数改为倒数第二小的数相同
        int res1 = nums[len-2] - nums[1];
        // 2. 将最小的两个数改为与倒数第三小的数相同
        int res2 = nums[len-1] - nums[2];
        // 3. 将最大的两个数，改为与第三大的数相同
        int res3 = nums[len-3] - nums[0];

        return Math.min(res1, Math.min(res2, res3));
    }
}
