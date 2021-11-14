package com.fuqi.year2021.month11.day20211113;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2021/11/14 14:56
 * @description
 */
public class Solution05912 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];
        // 按照item[0]升序,同样的item[0],按照item[1]降序
        Arrays.sort(items, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        // 将items数组中的item[1]更新为最大值
        int maxBeauty = 0;
        for (int[] item : items) {
            maxBeauty = Math.max(maxBeauty, item[1]);
            item[1] = maxBeauty;
        }
        // 对每个query进行二分查找, 找出其最大美丽值
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int left = 0, right = items.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (items[mid][0] <= query) {
                    // 因为每个query不一定能在items中找到价格完全一致的
                    // 只需要找出价格小于等于当前query的items中最大的美丽值即可
                    ans[i] = items[mid][1];
                    left = mid + 1;
                } else {
                    right = mid-1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] items = new int[][]{{1,2},{3,2},{2,4},{5,6},{3,5}};
        Arrays.sort(items, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        System.out.println();
    }
}
