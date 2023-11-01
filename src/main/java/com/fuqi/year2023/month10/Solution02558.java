package com.fuqi.year2023.month10;

import java.util.PriorityQueue;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/10/28 15:11
 * @description
 */
public class Solution02558 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) maxHeap.offer(gift);

        while (k > 0) {
            Integer curMax = maxHeap.poll();
            maxHeap.offer((int) Math.sqrt(curMax));
            k--;
        }

        long ans = 0;
        while (!maxHeap.isEmpty()) ans += maxHeap.poll();

        return ans;
    }
}
