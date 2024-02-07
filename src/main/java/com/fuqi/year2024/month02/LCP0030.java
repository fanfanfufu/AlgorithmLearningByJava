package com.fuqi.year2024.month02;

import java.util.PriorityQueue;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/2/6 21:39
 * @description
 */
public class LCP0030 {
    public int magicTower(int[] nums) {
        int ans = 0;
        long hp = 1, negSum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            if (num < 0) priorityQueue.offer(num);
            hp += num;
            if (hp < 1) {
                ans++;
                int minNeg = priorityQueue.poll();
                negSum += minNeg;
                hp -= minNeg;
            }
        }
        hp += negSum;

        return hp < 1 ? -1 : ans;
    }
}
