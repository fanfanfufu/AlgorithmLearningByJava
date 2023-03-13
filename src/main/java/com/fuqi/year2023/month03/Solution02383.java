package com.fuqi.year2023.month03;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/3/13 22:59
 * @description
 */
public class Solution02383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int energySum = Arrays.stream(energy).sum();
        int ans = initialEnergy > energySum ? 0 : (energySum-initialEnergy+1);
        for (int exp : experience) {
            if (initialExperience > exp) {
                // 如果初始经验大于当前对手的经验，则直接进行累加
                initialExperience += exp;
                continue;
            }
            // 否则说明累积到现在的经验不如当前对手的经验，
            // 因此可以算出需要训练的最小时长
            ans = exp-initialExperience+1 + ans;
//            initialExperience = initialExperience + (exp-initialExperience) + 1 + exp;
            // 此时经验的累积可以优化为下面的计算式
            initialExperience = 2 * exp + 1;
        }

        return ans;
    }
}
