package com.fuqi.year2021.month08.day20210822;

import java.util.Arrays;

/**
 * @author FuQi
 */
public class Solution1 {
    public static int findGCD(int[] nums) {
        int maxNum = nums[0];
        int minNum = nums[0];
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }

        for (int i = minNum; i > 0; i--) {
            int minTail = minNum % i;
            int maxTail = maxNum % i;
            if (minTail == 0 && maxTail == 0) {
                return i;
            }
        }

        return 1;
    }
}
