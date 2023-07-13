package com.fuqi.year2023.month07;

import java.util.Arrays;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/9 10:36
 * @description
 */
public class Solution06899 {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // 需要从第一个元素开始，所以第一个元素的跳跃次数标记为0
        dp[0] = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int delta = nums[j] - nums[i];
                if (Math.abs(delta) <= target) {
                    // 如果差满足咋target的范围内
                    if (dp[i] == -1) continue;
                    dp[j] = Math.max(dp[j], dp[i]+1);
                }
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution06899 solution06899 = new Solution06899();
//        int[] nums = {1,3,6,4,1,2};
//        int target = 2;
//        int[] nums = {1,3,6,4,1,2};
//        int target = 3;
//        int[] nums = {1,3,6,4,1,2};
//        int target = 0;
        int[] nums = {1,3,4,0,2};
        int target = 2;
        System.out.println(solution06899.maximumJumps(nums, target));
    }
}
