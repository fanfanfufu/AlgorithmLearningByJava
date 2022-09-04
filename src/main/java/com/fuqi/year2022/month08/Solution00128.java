package com.fuqi.year2022.month08;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author FuQi
 * @date 2022/9/4 16:19
 * @description
 */
public class Solution00128 {
    public static int longestConsecutive1(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        // 对数组排序
        Arrays.sort(nums);
        // 寻找最长连续序列

        return searchLongestSequenceLengthForSortedArray(nums);
    }

    public static int searchLongestSequenceLengthForSortedArray(int[] nums) {
        int ans = 1;
        int start = nums[0];
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == start + 1) {
                temp++;
                start = nums[i];
                continue;
            }
            start = nums[i];
            ans = Math.max(ans, temp);
            temp = 1;
        }
        ans = Math.max(ans, temp);

        return ans;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int ans = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int cur = num;
                int curLen = 1;
                while (numSet.contains(cur + 1)) {
                    cur += 1;
                    curLen += 1;
                }

                ans = Math.max(ans, curLen);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0, 0, 1, 2, 3, 5, 100, 400};
//        int[] nums = new int[]{100,4,200,1,3,2};
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive1(nums));
    }
}
