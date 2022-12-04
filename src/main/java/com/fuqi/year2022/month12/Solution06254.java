package com.fuqi.year2022.month12;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2022/12/4 10:59
 * @description
 */
public class Solution06254 {
    public long dividePlayers(int[] skill) {
        // 1. 先排序
        Arrays.sort(skill);
        int len = skill.length;
        // 2. 判断是否有元素之和不相等，同时计算元素对乘积之和
        int left = 0, right = len-1;
        int pairSum = skill[left] + skill[right];
        long ans = 0L;
        while (left < right) {
            int cur = skill[left] + skill[right];
            if (pairSum != cur) {
                return -1L;
            }
            ans += ((long) skill[left] * skill[right]);
            left++;
            right--;
        }

        return ans;
    }
}
