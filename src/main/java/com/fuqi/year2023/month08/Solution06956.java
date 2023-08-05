package com.fuqi.year2023.month08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/6 00:24
 * @description 使循环数组所有元素相等的最少秒数
 */
public class Solution06956 {
    /**
     * 核心：实质就是求选定一个数字向左右同时扩散，能够满足题目要求的最小单侧扩散距离。
     *
     * 可以考虑用哈希记录同一数字的下标序列，然后找到同数字相邻下标的最大距离除二取上整，对每个数字都可以有一个"最大距离"，
     * 找到所有不同数字的"最大距离"的最小值即为答案。
     *
     * @param nums
     * @return
     */
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        // hm用于记录同一个元素值在原数组中的不同位置
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) hm.computeIfAbsent(nums.get(i), key -> new ArrayList<>()).add(i);

        int min = n / 2;
        for (List<Integer> list : hm.values()) {
            list.add(list.get(0) + n);
            int m = list.size();
            int max = 0;
            for (int i = 0; i < m - 1; i++) {
                int t = list.get(i + 1) - list.get(i);
                max = Math.max(max, t / 2);
            }
            min = Math.min(min, max);
        }
        return min;
    }
}
