package com.fuqi.year2021.month08.day20210829;

import java.util.Arrays;

/**
 * @author FuQi
 */
public class Solution5854 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        if (k == 1) {
            return 0;
        }
        if (k == nums.length) {
            return nums[nums.length - 1] - nums[0];
        }
        int i = 0, j = k-1;
        int ans = Integer.MAX_VALUE;
        while (j < nums.length) {
            int curMin = nums[i];
            int curMax = nums[j];
            ans = Math.min(ans, (curMax-curMin));
            i++;
            j++;
        }

        return ans;
    }
}
