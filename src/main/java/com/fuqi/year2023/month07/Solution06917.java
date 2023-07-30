package com.fuqi.year2023.month07;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/30 10:33
 * @description
 */
public class Solution06917 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int hour : hours) {
            if (hour < target) continue;
            ans++;
        }

        return ans;
    }
}
