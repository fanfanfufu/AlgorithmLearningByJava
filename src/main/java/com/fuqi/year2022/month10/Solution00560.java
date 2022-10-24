package com.fuqi.year2022.month10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FuQi
 * @date 2022/10/24 23:05
 * @description
 */
public class Solution00560 {
    /**
     * 我们定义 pre[i]pre[i] 为 [0..i][0..i] 里所有数的和，则 pre[i]pre[i] 可以由 pre[i-1]pre[i−1] 递推而来，即：
     *
     * pre[i]=pre[i−1]+nums[i]
     *
     * 那么[j,i]这个子数组和为k这个条件我们可以转化为
     *
     * pre[i]−pre[j−1]==k
     *
     * 简单移项可得符合条件的下标 j 需要满足
     *
     * pre[j−1]==pre[i]−k
     * 
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (preSumMap.containsKey(pre - k)) {
                count += preSumMap.get(pre - k);
            }
            preSumMap.put(pre, preSumMap.getOrDefault(pre, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution00560 solution00560 = new Solution00560();
        int[] nums = new int[]{3,4,7,2,-3,1,4,2};
        int k = 7;
        System.out.println(solution00560.subarraySum(nums, k));
    }
}
