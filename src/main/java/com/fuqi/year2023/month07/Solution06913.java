package com.fuqi.year2023.month07;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/8 22:32
 * @description
 */
public class Solution06913 {
    public int alternatingSubarray(int[] nums) {
        int i= 0, j = i+1;
        int n = nums.length;
        int ans = -1;
        while (i < n && j < n) {
            if (nums[j] - nums[j-1] != 1) {
                i++;
                j++;
                continue;
            }
            while (j < n) {
                if (j+1 == n) {
                    ans = Math.max(ans, j-i+1);
                    return ans;
                }
                if (nums[j+1] != nums[j-1]) {
                    break;
                }
                j++;
            }
            ans = Math.max(ans, j-i+1);
            i = j;
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution06913 solution06913 = new Solution06913();
//        int[] nums = {2,3};
//        int[] nums = {2,3,4,3,4};
//        int[] nums = {4,5,6};
//        int[] nums = {2,5,7,9};
        int[] nums = {14,30,29,49,3,23,44,21,26,52};
        System.out.println(solution06913.alternatingSubarray(nums));
    }
}
