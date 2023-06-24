package com.fuqi.year2022.month02;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/2/11 21:59
 * @description
 */
public class Solution00209 {
    /**
     * 滑动窗口
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen1(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        int sum = 0;
        Deque<Integer> window = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            window.offerLast(num);
            sum += num;
            while (sum >= target) {
                minSize = Math.min(minSize, window.size());
                sum -= window.pollFirst();
            }
        }

        return (minSize == Integer.MAX_VALUE ? 0 : minSize);
    }

    /**
     * 滑动窗口优化
     * 省掉采用队列结构操作数据得耗时
     * 同向双指针
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        int left = 0, right = 0, sum = 0;
        int minSize = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            right++;
            while (sum >= target) {
                minSize = Math.min(minSize, right-left);
                sum -= nums[left];
                left++;
            }
        }

        return (minSize == Integer.MAX_VALUE ? 0 : minSize);
    }

    /**
     * 前缀和+二分查找
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen3(int target, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        // 为了方便计算，前缀和数组长度设置为len+1
        int[] sums = new int[len+1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        for (int i = 1; i < sums.length; i++) {
            int temp = target + sums[i];
            int index = Arrays.binarySearch(sums,  temp);
            if (index < 0) {
                index = -index-1;
            }
            if (index < sums.length) {
                ans = Math.min(ans, index-i+1);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen1(target, nums));
    }
}
