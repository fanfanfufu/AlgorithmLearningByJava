package com.fuqi.year2023.month03;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/3/12 11:23
 * @description
 */
public class Solution06316 {
    /**
     * 暴力解法，但是会超时
     *
     * @param nums
     * @return
     */
    public int maxScore(int[] nums) {
        int score = 0;
        long prefix = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            prefix += nums[i];
            if (prefix <= 0) break;
            score++;
        }

        return score;
    }

    public static void main(String[] args) {
        Solution06316 solution06316 = new Solution06316();
        int[] nums = new int[]{-687767,-860350,950296,52109,510127,545329,-291223,-966728,852403,828596,456730,-483632,-529386,356766,147293,572374,243605,931468,641668,494446};
        int score = solution06316.maxScore(nums);
        System.out.println(score);
    }
}
