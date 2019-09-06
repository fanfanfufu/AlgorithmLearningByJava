package com.fuqi.month09.小米;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/9/6 19:51
 * @Version V1.0
 */
public class Main1 {
    private static int helper(int[] prices, int budget) {
        if (prices.length == 0 || budget < 1) { return -1; }

        int maxPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxPrice = maxPrice > prices[i] ? maxPrice : prices[i];
        }

        int quantities = budget / maxPrice;
        return quantities;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int types = scanner.nextInt();
        int[] prices = new int[types];
        for (int i = 0; i < types; i++) {
            prices[i] = scanner.nextInt();
        }
        int budget = scanner.nextInt();
        System.out.println(helper(prices, budget));

        scanner.close();
    }
}
