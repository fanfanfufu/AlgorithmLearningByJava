package com.fuqi.year2023.month05;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/7 11:11
 * @description
 */
public class Solution06416 {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int[] pre = new int[n];
        int[] suf = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            pre[i] = set.size();
        }
        set.clear();
        set.add(nums[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = set.size();
            set.add(nums[i]);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre[i] - suf[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution06416 solution06416 = new Solution06416();
//        int[] nums = {1,2,3,4,5};
//        int[] nums = {3,2,3,4,2};
//        int[] nums = {1,1,1};
        int[] nums = {1};
        solution06416.distinctDifferenceArray(nums);
    }
}
