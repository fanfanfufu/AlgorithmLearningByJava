package com.fuqi.year2023.month03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/3/8 22:49
 * @description
 */
public class Solution02580 {
    public int countWays(int[][] ranges) {
        // 根据每个区间的左边界进行升序排列
        Arrays.sort(ranges, Comparator.comparingInt(o -> o[0]));
        // 记录不想交的区间集合个数
        int count = 1, right = ranges[0][1];
        for (int i = 1; i < ranges.length; i++) {
            if (right < ranges[i][0]) {
                // 如果前面集合的右边界小于当前区间的左边界
                // 说明前面的区间集合与后面的区间都不会相交了，因此对count进行计数
                count++;
                // 更新右边界
                right = ranges[i][1];
            } else {
                // 更新右边界的值
                right = Math.max(right, ranges[i][1]);
            }
        }

        int ans = 1;
        for (int i = 0; i < count; i++) {
            ans = (ans + ans) % (1000000007);
        }

        return ans;
    }
}
