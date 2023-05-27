package com.fuqi.year2023.month05;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/27 22:34
 * @description
 */
public class Solution06395 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if (prices[0] + prices[1] > money) return money;

        return money - prices[0] - prices[1];
    }
}
