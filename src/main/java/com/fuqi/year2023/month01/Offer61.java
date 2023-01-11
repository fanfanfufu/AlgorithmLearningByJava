package com.fuqi.year2023.month01;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FuQi
 * @date 2023/1/11 21:48
 * @description
 */
public class Offer61 {
    /**
     * 因为要5张牌是连续的，由于大小王是可以代替任意的牌的，
     * 所以必须要满足
     * max - min < 5
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> card = new HashSet<>();
        int min = 14, max = 0;
        for (int num : nums) {
            // 遇到大小王则直接跳过
            if (num == 0) continue;
            // 更新最大最小的值
            min = Math.min(min, num);
            max = Math.max(max, num);
            // 快速失败判断
            // 如果现有牌组中包含了当前牌的数字，
            // 则说明有重复的非大小王牌，则无法构成顺子的排序，所以直接返回false
            if (card.contains(num)) return false;
            card.add(num);
        }

        return max - min < 5;
    }
}
