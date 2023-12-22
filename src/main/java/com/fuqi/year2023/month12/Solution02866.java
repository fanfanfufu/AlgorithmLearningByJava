package com.fuqi.year2023.month12;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/12/21 22:01
 * @description 美丽塔II
 */
public class Solution02866 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        // 6,5,3,9,2,7
        if (n == 1) return maxHeights.get(0);
        long[] suff = new long[n + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(n);
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cur = maxHeights.get(i);
            while (deque.size() > 1 && cur <= maxHeights.get(deque.peekFirst())) {
                int j = deque.pollFirst();
//                sum -= (long) maxHeights.get(j) * (deque.peekFirst() - j);
                sum -= ((long) (maxHeights.get(j) - cur) * (deque.peekFirst() - j));
            }
//            sum += ((long) cur * (deque.peekFirst() - i));
            sum += cur;
            suff[i] = sum;
            deque.offerFirst(i);
        }

        long ans = sum;
        deque.clear();
        deque.offerFirst(-1);
        long pre = 0;
        for (int i = 0; i < n; i++) {
            int cur = maxHeights.get(i);
            while (deque.size() > 1 && cur <= maxHeights.get(deque.peekFirst())) {
                int j = deque.pollFirst();
//                pre -= ((long) maxHeights.get(j) * (j - deque.peekFirst()));
                pre -= ((long) (maxHeights.get(j) - cur) * (j - deque.peekFirst()));
            }
//            pre += ((long) cur * (i - deque.peekFirst()));
            pre += cur;
            deque.offerFirst(i);
            ans = Math.max(pre + suff[i + 1], ans);
        }

        return ans;
    }
}
