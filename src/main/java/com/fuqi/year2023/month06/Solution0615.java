package com.fuqi.year2023.month06;

import org.junit.jupiter.api.Assertions;

public class Solution0615 {
    public static void main(String[] args) {
        int[][] skill_list = {{10,10}, {12,13}};
        int[][] skill_list2 = {{10,10}, {12,13}};
        int[][] skill_list3 = {{2,5}, {4,11}, {7,20}};
        int current_mana = 20;
        int current_mana2 = 25;
        int current_mana3 = 13;
        Assertions.assertEquals(20, getMaxDamage(skill_list, current_mana));
        Assertions.assertEquals(26, getMaxDamage(skill_list2, current_mana2));
        Assertions.assertEquals(36, getMaxDamage(skill_list3, current_mana3));
    }

    public static int getMaxDamage(int[][] skill_list, int current_mana) {
        int len = skill_list.length;
        int[][] dp = new int[len+1][current_mana+1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= current_mana; j++) {
                if (j < skill_list[i-1][0]) { dp[i][j] = dp[i][j-1]; }
                else {
                    dp[i][j] = Math.max(dp[i][j-skill_list[i-1][0]] + skill_list[i-1][1], dp[i-1][j]);
                }
            }
        }

        return dp[len][current_mana];
    }
}
