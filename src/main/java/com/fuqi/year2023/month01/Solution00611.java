package com.fuqi.year2023.month01;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2023/1/13 21:48
 * @description 有效的三角形个数
 */
public class Solution00611 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i+1; j < n; j++) {
                while (k + 1 < n && nums[k+1] < nums[i] + nums[j]) {
                    k++;
                }
                ans += Math.max(k - j, 0);
            }
        }

        return ans;
    }
}
