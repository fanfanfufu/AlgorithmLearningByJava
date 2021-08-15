package com.fuqi.year2021.month08.day20210815;

import java.util.Arrays;

/**
 * @author FuQi
 */
public class Solution2 {
    public static int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans[i] = nums[index++];
        }
        for (int i = 1; i < nums.length; i += 2) {
            ans[i] = nums[index++];
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,4,5};
        int[] nums = new int[]{6,2,0,9,7};
        int[] ans = rearrangeArray(nums);
        Arrays.stream(ans).forEach(System.out::println);
    }
}
