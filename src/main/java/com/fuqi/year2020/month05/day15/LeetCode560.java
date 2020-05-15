package com.fuqi.year2020.month05.day15;

import java.util.HashMap;

/**
 * @Description: 和为K的子数组
 * @Author 傅琦
 * @date 2020/5/15 10:29
 * @Version V1.0
 */
public class LeetCode560 {
    /**
     * 所以我们考虑以 i 结尾的和为 k 的连续子数组个数时只要统计有多少个前缀和为 pre[i]−k 的 pre[j] 即可。
     * 我们建立哈希表 mp，以和为键，出现次数为对应的值，记录 pre[i] 出现的次数，
     * 从左往右边更新 mp 边计算答案，那么以 i 结尾的答案 mp[pre[i]−k] 即可在 O(1) 时间内得到。
     * 最后的答案即为所有下标结尾的和为 k 的子数组个数之和。
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap< >();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode560 leetCode560 = new LeetCode560();
        int[] nums = new int[]{2,1,1,1};
        int k = 2;
        System.out.println(leetCode560.subarraySum(nums, k));
    }
}
