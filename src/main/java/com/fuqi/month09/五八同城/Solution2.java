package com.fuqi.month09.五八同城;

import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/9/16 20:56
 * @Version V1.0
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().trim().split(",");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.valueOf(input[i]);
        }
        System.out.println(helper(arr));

        scanner.close();
    }

    private static int helper(int[] arr) {
        return 0;
    }
}
