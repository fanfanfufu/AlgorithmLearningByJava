package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/19 23:13
 * @description
 */
public class Solution00045 {
    /**
     * 反向贪心算法
     *
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    /**
     * 正向贪心
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int len = nums.length;
        int end = 0, maxPosition = 0, steps = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, i+nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }

        return steps;
    }
}
