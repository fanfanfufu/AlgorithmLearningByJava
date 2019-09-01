package com.fuqi.month09.拼多多寻梦;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/9/1 15:22
 * @Version: V1.0
 */
public class Main4 {
    private static void helper(int n, int m, int k) {
        // 降序排列的堆
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                queue.offer(i * j);
            }
        }

        for (int i = 0; i < k-1; i++) {
            queue.poll();
        }

        System.out.println(queue.poll());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        helper(n, m, k);

        scanner.close();
    }
}
