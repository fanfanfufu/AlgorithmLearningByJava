package com.fuqi.year2021.month08.day20210808;

import java.util.PriorityQueue;

/**
 * @author FuQi
 */
public class Solution2 {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int pile : piles) {
            heap.offer(pile);
        }

        for (int i = 0; i < k; i++) {
            Integer cur = heap.poll();
            heap.offer((int) Math.ceil((double) cur / 2));
        }

        return heap.stream().mapToInt(i -> i).sum();
    }

    public static void main(String[] args) {
        int[] piles = new int[] {4,3,6,7};
        int k = 3;
        System.out.println(minStoneSum(piles, k));
    }
}
