package com.fuqi.year2022.month11;

/**
 * @author FuQi
 * @date 2022/11/21 22:59
 * @description
 */
public class Solution00026 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[i+1] = nums[j];
                i++;
            }
            j++;
        }

        return i+1;
    }
}
