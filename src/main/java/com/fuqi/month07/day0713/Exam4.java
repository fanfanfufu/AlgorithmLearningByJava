package com.fuqi.month07.day0713;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 将数组分成几个递增序列
 *
 * 给你一个非递减的正整数数组nums和整数K，判断该数组是否可以被分成一个或几个长度至少为K的不相交的递增子序列。
 *
 * 输入：nums = [1,2,2,3,3,4,4], K = 3
 * 输出：true
 * 解释：
 * 该数组可以分成两个子序列 [1,2,3,4] 和 [2,3,4]，每个子序列的长度都至少是 3。
 *
 * 输入：nums = [5,6,6,7,8], K = 3
 * 输出：false
 * 解释：
 * 没有办法根据条件来划分数组。
 *
 * @Author: 傅琦
 * @DateTime: 2019/7/13 22:30
 * @Version: V1.0
 */
public class Exam4 {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        Map<Integer, Integer> count = new HashMap<>();
        int mx = 0;
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            mx = Math.max(mx, count.get(nums[i]));
        }

        if (mx * K > nums.length){ return false; }
        return true;
    }
}
