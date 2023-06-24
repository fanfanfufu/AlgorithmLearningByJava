package com.fuqi.year2023.month05;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/21 22:35
 * @description
 */
public class Solution06441 {
    private final static int[] PRE_SUM = new int[1001];

    static {
        for (int i = 1; i <= 1000; i++) {
            char[] array = Integer.toString(i * i).toCharArray();
            PRE_SUM[i] = PRE_SUM[i - 1] + (dfs(array, i, 0, 0) ? i * i : 0);
        }
    }

    private static boolean dfs(char[] array, int target, int index, int sum) {
        if (index == array.length) return sum == target;
        int x = 0;
        for (int i = index; i < array.length; i++) {
            x = x * 10 + array[i] - '0';
            if (dfs(array, target, i + 1, sum + x)) return true;
        }

        return false;
    }

    public int punishmentNumber(int n) {
        return PRE_SUM[n];
    }
}
