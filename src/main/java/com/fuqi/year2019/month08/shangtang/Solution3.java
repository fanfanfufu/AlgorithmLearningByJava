package com.fuqi.year2019.month08.shangtang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/19 20:38
 * @Version V1.0
 */
public class Solution3 {
    private static void helper(long n, int a, int b, int c, int initialMoney) {
        Queue<Long> queue = new LinkedList<>();
        long count = 1;
        long first = initialMoney;
        long second = a * first + 2 * (count * count) - count + 32767;
        count++;
        long third = a * second + b * first + 2 * (count * count) - count + 32767;
        count++;
        queue.offer(first);
        queue.offer(second);
        queue.offer(third);
        while (count <= n){
            long temp1 = queue.poll();
            long temp2 = queue.poll();
            long temp3 = queue.poll();

            long temp4 = a*temp3 + b*temp2 + c*temp1 + 2*(count*count) - count + 32767;
            queue.offer(temp2);
            queue.offer(temp3);
            queue.offer(temp4);
            count++;
        }

        queue.poll();
        queue.poll();
        System.out.println(queue.poll());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 暂时用int代替
        long n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int initialMoney = scanner.nextInt();
        helper(n, a, b, c, initialMoney);
        scanner.close();
    }
}
