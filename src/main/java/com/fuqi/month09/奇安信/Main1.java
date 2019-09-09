package com.fuqi.month09.奇安信;

import java.util.*;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/9/9 20:33
 * @Version V1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line1 = scanner.nextLine().split(" ");
        int[] pids = new int[line1.length];
        for (int i = 0; i < line1.length; i++) {
            pids[i] = Integer.valueOf(line1[i]);
        }
        String[] line2 = scanner.nextLine().split(" ");
        int[] ppids = new int[line2.length];
        for (int i = 0; i < line2.length; i++) {
            ppids[i] = Integer.valueOf(line2[i]);
        }

        int pid = Integer.valueOf(scanner.nextLine());

        System.out.println(helper(pids, ppids, pid));

        scanner.close();
    }

    private static int helper(int[] pids, int[] ppids, int id) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int count = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < ppids.length; i++) {
                if (!queue.isEmpty() && queue.peek() == ppids[i]) {
                    queue.add(pids[i]);
                }
            }
            queue.poll();
            count++;
        }

        return count;
    }
}
