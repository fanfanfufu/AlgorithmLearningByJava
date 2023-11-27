package com.fuqi.year2023.month11;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/11/24 21:11
 * @description
 */
public class Solution02824 {
    /**
     * 非暴力方法
     *
     * @param nums
     * @param target
     * @return
     */
    public int countPairs(List<Integer> nums, int target) {
        // 1 先升序排列
        Collections.sort(nums);
        int ans = 0;
        if (nums.get(0) >= target) return ans;
        int n = nums.size();
        for (int i = 1; i < n; i++) {
            if (nums.get(i) >= target) break;
            int cnt = findMax(i-1, target- nums.get(i), nums);
            ans += cnt;
        }

        return ans;
    }

    private int findMax(int right, int target, List<Integer> nums) {
        int ans = right+1, left = 0;
        while (left < right) {
            int mid = (left+right)/2;
            if (nums.get(mid) < target) {
                left = mid+1;
            } else {
                ans = mid;
                right = mid-1;
            }
        }

        return ans;
    }

    /**
     * 非暴力解法：双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int countPairs2(List<Integer> nums, int target) {
        // 1 先升序排列
        Collections.sort(nums);
        int ans = 0, left = 0, right = nums.size()-1;
        while (left < right) {
            while (left < right && nums.get(left) + nums.get(right) >= target) right--;
            ans += (right-left);
            left++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution02824 solution02824 = new Solution02824();
        List<Integer> nums = Stream.of(-1,1,2,3,1).collect(Collectors.toList());
        int target = 2;
        System.out.println(solution02824.countPairs(nums, target));
    }
}
