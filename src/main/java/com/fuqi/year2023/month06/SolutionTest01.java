package com.fuqi.year2023.month06;

import java.util.Scanner;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/1 19:59
 * @description
 */
public class SolutionTest01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int input = in.nextInt();
            if (input == 0) return;
            System.out.println(canDrink(input));
        }
    }

    public static int canDrink(int input) {
        if (input == 1) return 0;
        if (input == 2) return 1;
        int[] dp = new int[input+1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= input; i++) {
            int x = i / 3;
            int y = i % 3;
            dp[i] = dp[x+y] + x;
        }

        return dp[input];
    }
}
