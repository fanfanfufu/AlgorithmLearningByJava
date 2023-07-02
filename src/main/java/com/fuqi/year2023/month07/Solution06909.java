package com.fuqi.year2023.month07;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/2 10:34
 * @description
 */
public class Solution06909 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        if (n == 1) {
            if (nums[0] % 2 != 0) return 0;
            if (nums[0] > threshold) return 0;
            return 1;
        }
        int ans = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (nums[i] % 2 != 0 || nums[i] > threshold) {
                i++;
                continue;
            }
            j = i+1;
            while (j < n) {
                if ((nums[j - 1] % 2 != nums[j] % 2) && nums[j] <= threshold) {
                    j++;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, (j - i));
            i = j;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution06909 solution06909 = new Solution06909();
        int[] nums = {2,3,4,5};
        int threshold = 2;
        System.out.println(solution06909.longestAlternatingSubarray(nums, threshold));
    }
}
