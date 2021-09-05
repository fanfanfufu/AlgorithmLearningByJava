package com.fuqi.year2021.month09.day20210905;

import java.util.Arrays;

/**
 * @author FuQi
 */
public class Solution05863 {
    public static int countQuadruplets(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < nums.length-3; i++) {
            if (nums[i] == max) {
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                for (int k = j+1; k < nums.length-1; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    for (int l = k+1; l < nums.length; l++) {
                        if (sum == nums[l]) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{28,8,49,85,37,90,20,8};
        int[] nums = new int[]{35,15,38,1,10,26};
        System.out.println(countQuadruplets(nums));
    }
}
