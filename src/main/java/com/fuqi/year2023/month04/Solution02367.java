package com.fuqi.year2023.month04;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/1 21:05
 * @description
 */
public class Solution02367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        Map<Integer, Integer> map =
                IntStream.range(0, nums.length).boxed().collect(Collectors.toMap(i -> nums[i], i -> i));
        int ans = 0;
        for (int first : nums) {
            int second = first + diff;
            int third = second + diff;
            if (map.containsKey(second) && map.containsKey(third)) {
                ans++;
            }
        }

        return ans;
    }


}
