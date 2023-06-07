package com.fuqi.year2023.month06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/7 23:04
 * @description
 */
public class HuaWei0007 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) continue;
            boolean leftFlag = i == 0 || nums[i-1] == 0;
            boolean rightFlag = i == nums.length-1 || nums[i+1] == 0;
            if (leftFlag && rightFlag) {
                ans++;
                nums[i] = 1;
            }
        }

        System.out.println(ans);
    }
}
