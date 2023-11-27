package com.fuqi.year2023.month11;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/11/27 21:27
 * @description 子数组的最小值之和
 */
public class Solution00907 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<Integer> monoStack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && arr[i] <= arr[monoStack.peekFirst()]) {
                monoStack.pollFirst();
            }
            left[i] = i - (monoStack.isEmpty() ? -1 : monoStack.peekFirst());
            monoStack.offerFirst(i);
        }
        monoStack.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!monoStack.isEmpty() && arr[i] < arr[monoStack.peekFirst()]) {
                monoStack.pollFirst();
            }
            right[i] = (monoStack.isEmpty() ? n : monoStack.peekFirst()) - i;
            monoStack.offerFirst(i);
        }
        long ans = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) left[i] * right[i] * arr[i]) % MOD;
        }

        return (int) ans;
    }
}
