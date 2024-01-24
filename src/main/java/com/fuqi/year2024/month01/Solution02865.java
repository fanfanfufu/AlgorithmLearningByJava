package com.fuqi.year2024.month01;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/1/24 21:43
 * @description 美丽塔｜
 */
public class Solution02865 {
    public long maximumSumOfHeights(List<Integer> maxHeights){
        int n = maxHeights.size();
        // 存储以 maxHeights[i] 为顶点，左侧的美丽塔之和（包括自身）
        long[] prefix = new long[n];
        // 存储以 maxHeights[i] 为顶点，右侧的美丽塔之和（包括自身）
        long[] suffix = new long[n];

        // 从左侧往顶点走是递增的，从右侧往顶点走也是递增的，所以都是递增单调栈
        Deque<Integer> pre = new ArrayDeque<>();
        Deque<Integer> suf = new ArrayDeque<>();
        // 先求每个顶点左侧的
        for (int i = 0; i < n; i++) {
            // 递增栈，要把栈里比 maxHeights[i] 大的出栈
            while (!pre.isEmpty() && maxHeights.get(i) < maxHeights.get(pre.peek())){
                pre.pop();
            }
            // 如果为空，说明是第一个或者前面的都比 maxHeights[i] 大，所以以maxHeights[i]为顶点时，
            // 左侧的 heights[j] 都应该取maxHeights[i], 所以 prefix[i] = (long) (i + 1) * maxHeights.get(i);
            if(pre.isEmpty()){
                prefix[i] = (long) (i + 1) * maxHeights.get(i);
            }else {
                // 如果不为空， 假设当前栈顶的下标是 j, 则 [0, j] 区间都是小于 maxHeights[i] 的，这个区间上的美丽塔之和是 prefix[j],
                // 而[j + 1, i] 之间的值都是大于 maxHeights[i]，所以这个区间的美丽塔值是 (long) (i - pre.peek()) * maxHeights.get(i), 两者相加即可
                prefix[i] = prefix[pre.peek()] + (long) (i - pre.peek()) * maxHeights.get(i);
            }
            pre.push(i);
        }
        // 求每个顶点右侧的，跟上面原理相同。
        for (int i = n - 1; i >= 0; i --) {
            // 递增栈
            while (!suf.isEmpty() && maxHeights.get(i) < maxHeights.get(suf.peek())){
                suf.pop();
            }
            if(suf.isEmpty()){
                suffix[i] = (long) (n - i) * maxHeights.get(i);
            }else {
                suffix[i] = suffix[suf.peek()] + (long) (suf.peek() - i) * maxHeights.get(i);
            }
            suf.push(i);
        }
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, prefix[i] + suffix[i] - maxHeights.get(i));
        }
        return ans;
    }
}
