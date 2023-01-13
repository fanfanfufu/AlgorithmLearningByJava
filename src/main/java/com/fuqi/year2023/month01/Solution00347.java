package com.fuqi.year2023.month01;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author FuQi
 * @date 2023/1/13 21:25
 * @description
 */
public class Solution00347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 遍历计算每个不同元素的出现次数
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        // 2. 遍历出现次数的集合，用小顶堆统计出现次数是前K个的
        // 2.1 创建小顶堆，用次数来进行计算
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(m -> m[1]));
        // 2.2 遍历集合
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() < k) {
                queue.offer(new int[]{num, count});
                continue;
            }
            if (queue.peek()[1] < count) {
                queue.poll();
                queue.offer(new int[]{num, count});
            }
        }
        // 3. 构造输出结果
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }

        return ans;
    }
}
