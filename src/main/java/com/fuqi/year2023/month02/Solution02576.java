package com.fuqi.year2023.month02;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2023/2/27 22:27
 * @description
 */
public class Solution02576 {
    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        Arrays.sort(nums);
        if (n == 2) {
            return nums[1] >= (2 * nums[0]) ? 2 : 0;
        }

        int i = 0;
        for (int j = (n + 1) / 2; j < n; j++) {
            if (nums[i] * 2 <= nums[j]) {
                i++;
            }
        }

        return 2 * i;
    }
}
