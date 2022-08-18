package com.fuqi.year2022.month08;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author FuQi
 * @date 2022/8/18 23:15
 * @description
 */
public class Solution00169 {
    /**
     * 方法一：计数
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > (nums.length / 2)) {
                return entry.getKey();
            }
        }

        return 0;
    }

    /**
     * 摩尔投票法
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int ans = nums[0];
        int ansCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (ans == nums[i]) {
                ansCount++;
                continue;
            }
            ansCount--;
            if (ansCount == 0 && i < nums.length-1) {
                ans = nums[i+1];
            }
        }

        return ans;
    }
}
