package com.fuqi.year2023.month06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/7 23:13
 * @description
 */
public class HuaWei0008 {
    public static boolean check(int speed, int total, int time, int[] users) {
        boolean ans = true;
        for (int i = 0; i < time; i++) {
            total -= users[i];
            if (total < 0) return false;
            total += speed;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int time = in.nextInt();
        int totalInit = in.nextInt();
        int[] users = new int[time];
        int allUser = 0;
        for (int i = 0; i < time; i++) {
            users[i] = in.nextInt();
            allUser += users[i];
        }

        int left = 0, right = allUser - totalInit;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(mid, totalInit, time, users)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
