package com.fuqi.year2019.month09.拼多多寻梦;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/9/1 15:19
 * @Version: V1.0
 */
public class Main1 {
    private static void helper(long[] arr, int N) {
        Queue<Long> evenNumber = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o2 - o1);
            }
        });

        Queue<Long> oddNumber = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o2 - o1);
            }
        });

        for (long num : arr) {
            if (num % 2 == 0){
                evenNumber.add(num);
            }else {
                oddNumber.add(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!evenNumber.isEmpty() && N > 0){
            sb.append(evenNumber.poll());
            if (N > 1){
                sb.append(',');
            }
            N--;
        }

        while (!oddNumber.isEmpty() && N > 0){
            sb.append(oddNumber.poll());
            if (N > 1){
                sb.append(',');
            }
            N--;
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().trim().split(",");
        long[] arr = new long[input.length];
        int N = 0;
        for (int i = 0; i < input.length-1; i++) {
            arr[i] = Long.valueOf(input[i]);
        }
        String[] last = input[arr.length-1].split(";");
        arr[arr.length-1] = Long.valueOf(last[0]);
        N = Integer.valueOf(last[1]);

        helper(arr, N);

        scanner.close();
    }
}
