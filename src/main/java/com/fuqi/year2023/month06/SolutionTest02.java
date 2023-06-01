package com.fuqi.year2023.month06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/1 20:17
 * @description
 */
public class SolutionTest02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            n = in.nextInt();
            break;
        }
        int[] nums = new int[501];
        while (in.hasNextInt()) {
            int cur = in.nextInt();
            nums[cur] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) System.out.println(i);
        }
    }
}
