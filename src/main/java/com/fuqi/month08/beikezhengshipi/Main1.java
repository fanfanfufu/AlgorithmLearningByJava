package com.fuqi.month08.beikezhengshipi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/23 19:21
 * @Version V1.0
 */
public class Main1 {
    private static int helper(int S, int[] costs) {
        Arrays.sort(costs);
        int ans = 0;
        for (int i = 0; i < costs.length; i++) {
            if (S - costs[i] >= 0) {
                ans++;
                S -= costs[i];
            }else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int S = scanner.nextInt();
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = scanner.nextInt();
        }

        System.out.println(helper(S, costs));

        scanner.close();
    }
}
