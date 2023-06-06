package com.fuqi.year2023.month06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/5 21:48
 * @description
 */
public class HuaWei0003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] position = new int[n];
        for (int i = 0; i < n; i++) {
            position[i] = in.nextInt();
        }
        int m = in.nextInt();
        System.out.println(maxDistance(position, m));
    }

    private static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length-1] - position[0], ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private static boolean check(int x, int[] position, int m) {
        int pre = position[0], cnt = 1;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - pre >= x) {
                pre = position[i];
                cnt++;
            }
        }

        return cnt >= m;
    }
}
