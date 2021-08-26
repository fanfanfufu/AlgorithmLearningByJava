package com.fuqi.year2021.month08.day20210826;

/**
 * @author FuQi
 */
public class Solution167 {
    /**
     * 暴力解法
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        int[] ans = new int[2];
        int i = 0;
        while (i < numbers.length - 1) {
            for (int j = 0; j < numbers.length; j++) {
                if (target == numbers[i] + numbers[j]) {
                    ans[1] = j+1;
                    break;
                }
            }
            if (ans[1] != 0) {
                ans[0] = i+1;
                break;
            }
            i++;
        }

        return ans;
    }
}
