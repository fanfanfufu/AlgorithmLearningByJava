package com.fuqi.year2023.month05;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/27 22:51
 * @description
 */
public class Solution06393 {
    public long maxStrength(int[] nums) {
        if (nums.length == 1) return (long) nums[0];
        int[] pos = new int[10];
        int[] neg = new int[10];
        for (int num : nums) {
            if (num >= 0) pos[num]++;
            if (num < 0) neg[-num]++;
        }
        // 特殊情况: all num is zero
        if (pos[0] == nums.length) return 0;

        int negCount = 0;
        for (int i = 1; i < neg.length; i++) {
            if (neg[i] > 0) negCount += neg[i];
        }
        long ans = 0L;
        if (negCount % 2 == 1) {
            // neg num count is odd
            negCount -= 1;
        }
        // calculate negative number
        for (int i = neg.length-1; i > 0; i--) {
            if (negCount == 0) break;
            while (neg[i] > 0) {
                ans = ans == 0 ? -i : (ans * (-i));
                neg[i]--;
                negCount--;
                if (negCount == 0) break;
            }
        }
        for (int i = 1; i < pos.length; i++) {
            while (pos[i] > 0) {
                ans = (ans == 0) ? i : (ans * i);
                pos[i]--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution06393 solution06393 = new Solution06393();
//        int[] nums = {-5,5,-3,-7,-1,-5,5,1,-8};
//        int[] nums = {0,-1};
//        int[] nums = {0,1, -3};
        int[] nums = {-7,1, -6, 0};
        long ans = solution06393.maxStrength(nums);
        System.out.println(ans);
    }
}
