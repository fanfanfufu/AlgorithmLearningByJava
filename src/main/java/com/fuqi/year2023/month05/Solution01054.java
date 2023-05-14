package com.fuqi.year2023.month05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/14 22:29
 * @description
 */
public class Solution01054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int len = barcodes.length;
        // 特殊情况，只有一个数
        if (len < 2) return barcodes;

//        Map<Integer, Long> collect = Arrays.stream(barcodes).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Integer> counts = new HashMap<>();
        int maxCount = 0;
        for (int b : barcodes) {
            counts.put(b, counts.getOrDefault(b, 0) + 1);
            maxCount = Math.max(maxCount, counts.get(b));
        }

        int evenIndex = 0;
        int oddIndex = 1;
        int halfLength = len / 2;
        int[] ans = new int[len];
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            while (count > 0 && count <= halfLength && oddIndex < len) {
                ans[oddIndex] = num;
                count--;
                oddIndex += 2;
            }
            while (count > 0) {
                ans[evenIndex] = num;
                count--;
                evenIndex += 2;
            }
        }


        return ans;
    }
}
