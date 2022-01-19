package com.fuqi.year2022.month01;

import java.util.*;

/**
 * @author FuQi
 * @date 2022/1/19 22:34
 * @description
 */
public class Solution00219 {
    /**
     * 暴力循环，超时
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i-j) <= k) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 执行通过： 42ms
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexList = map.getOrDefault(nums[i], new ArrayList<>());
            indexList.add(i);
            map.put(nums[i], indexList);
        }
        for (Integer key : map.keySet()) {
            List<Integer> indexList = map.get(key);
            if (indexList.size() == 1) {
                continue;
            }
            for (int i = 0; i < indexList.size()-1; i++) {
                if (Math.abs(indexList.get(i) - indexList.get(i+1)) <= k) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 优化一
     * hashMap存储元素最新的坐标即可，
     * 如果遇到hashMap中有的key，则判断与最近的index的距离是否满足条件即可，
     * 满足则返回true，
     * 不满足则将最新的index放入hashMap中，并遍历下一个数字，
     * 直至遍历完，最后没有则返回false
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                if (Math.abs(i - indexMap.get(nums[i])) <= k) {
                    return true;
                }
            }
            indexMap.put(nums[i], i);
        }

        return false;
    }

    /**
     * 优化二：
     * 用一个hashSet来存储滑动窗口中的数字，
     * 若存在重复元素，则返回true，
     * 否则，窗口右移直至结束
     * 
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate4(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                // 超过k个数量上限的，则移除窗口最左边的元素
                set.remove(nums[i-k-1]);
            }
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
