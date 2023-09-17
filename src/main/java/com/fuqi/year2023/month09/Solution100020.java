package com.fuqi.year2023.month09;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/9/16 23:10
 * @description
 */
public class Solution100020 {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();
        if (n == 1) return 1;
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            Integer cnt = numCount.getOrDefault(num, 0) + 1;
            numCount.put(num,cnt);
        }
        // 1 如果只有一种数字，则无法进行删除操作，最小长度就是原来的长度
        if (numCount.size() == 1) return n;
        // 2 如果每隔数字都不相同，则最小长度根据原长度的奇偶行即可得到
        // 原来是奇数长度，则最终最小长度只会剩余一个
        // 原来是偶数长度，则都会被删除，最终长度为0
        if (numCount.size() == n) return ((n & 1) == 0) ? 0 : 1;
        // 3 部分数字重复
        int max = 0;
        for (Integer value : numCount.values()) {
            max = Math.max(max, value);
        }
        if (n % 2 == 1) {
            if (max * 2 <= n) {
                return 1;
            } else {
                int t = n - max;
                return n - t * 2;
            }
        }
        if (max * 2 <= n) {
            return 0;
        } else {
            int t = n - max;
            return n - t * 2;
        }
    }
}
