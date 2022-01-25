package com.fuqi.year2022.month01;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author FuQi
 * @date 2022/1/25 22:26
 * @description
 */
public class Solution00001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (Objects.isNull(map.get(b))) {
                map.put(nums[i], i);
                continue;
            }
            return new int[]{map.get(b), i};
        }

        return new int[2];
    }
}
