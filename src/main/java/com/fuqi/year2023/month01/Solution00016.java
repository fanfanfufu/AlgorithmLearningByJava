package com.fuqi.year2023.month01;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2023/1/4 22:07
 * @description 三数之和最相近的
 */
public class Solution00016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i+1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return sum;
                }
            }
        }

        return ans;
    }
}
