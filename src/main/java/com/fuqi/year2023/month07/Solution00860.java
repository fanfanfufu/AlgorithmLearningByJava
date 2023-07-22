package com.fuqi.year2023.month07;

import java.util.Deque;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/22 23:52
 * @description
 */
public class Solution00860 {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        if (n == 1 && bills[0] == 5) return true;
        if (bills[0] != 5) return false;
        int fiveCount = 1;
        int tenCount = 0;
        for (int i = 1; i < n; i++) {
            int money = bills[i];
            if (money == 5) {
                fiveCount++;
                continue;
            }
            if (money == 10) {
                if (fiveCount < 1) return false;
                fiveCount--;
                tenCount++;
            }
            if (money == 20) {
                if (fiveCount < 1 || (tenCount < 1 && fiveCount < 3)) return false;
                fiveCount--;
                if (tenCount > 0) {
                    tenCount--;
                    continue;
                }
                fiveCount -= 2;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution00860 solution00860 = new Solution00860();
        int[] bills = {5,5,10,10,20};
        System.out.println(solution00860.lemonadeChange(bills));
    }
}
