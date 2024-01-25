package com.fuqi.year2024.month01;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/1/25 22:00
 * @description
 */
public class Solution02859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0, n = nums.size();
        for (int i = 0; i < n; i++) {
            String biStr = Integer.toBinaryString(i);
            int oneSum = 0;
            for (char ch : biStr.toCharArray()) oneSum += (ch - '0');
            if (oneSum == k) ans += nums.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution02859 solution02859 = new Solution02859();
        List<Integer> nums = Stream.of(5, 10, 1, 5, 2).collect(Collectors.toList());
        int k = 1;
        int res = solution02859.sumIndicesWithKSetBits(nums, k);
        System.out.println(res);
    }
}
