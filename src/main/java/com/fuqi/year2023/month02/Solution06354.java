package com.fuqi.year2023.month02;

/**
 * @author FuQi
 * @date 2023/2/12 11:52
 * @description
 */
public class Solution06354 {
    public long findTheArrayConcVal(int[] nums) {
        if (nums.length == 1) return (long) nums[0];
        long ans = 0L;
        int i =0, j = nums.length-1;
        while (i <= j) {
            if (i == j) {
                ans = ans + (long) nums[i];
                break;
            }
            ans = ans + Long.parseLong(nums[i] + String.valueOf(nums[j]));
            i++;
            j--;
        }

        return ans;
    }
}
