package com.fuqi.month08.jingdong;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/24 19:57
 * @Version V1.0
 */
public class Main1 {
    private static void helper(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        Arrays.sort(arr);

        for (int height : arr) {

        }
        System.out.println(3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        helper(input);

        scanner.close();
    }
}
