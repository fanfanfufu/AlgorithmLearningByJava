package com.fuqi.year2023.month04;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution06360 {
    public long[] distance(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return new long[]{0L};
        }
        // 遍历数组将不同元素作为key, 统计key所在的index
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            if (numIndexMap.containsKey(nums[i])) {
                numIndexMap.get(nums[i]).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                numIndexMap.put(nums[i], indexList);
            }
        }

        long[] ans = new long[n];
        for (List<Integer> indexes : numIndexMap.values()) {
            if (indexes.size() == 1) {
                ans[indexes.get(0)] = 0;
                continue;
            }
            // 需要借助前缀和来优化时间复杂度
            int m = indexes.size(), first = indexes.get(0);
            long sum = 0;
            for (int index : indexes) {
                sum += Math.abs(index - first);
            }
            ans[first] = sum;
            for (int i = 1; i < m; i++) {
                sum = sum + (2*i - m) * (indexes.get(i) - indexes.get(i-1));
                ans[indexes.get(i)] = sum;
            }
        }

        return ans;
    }
}
