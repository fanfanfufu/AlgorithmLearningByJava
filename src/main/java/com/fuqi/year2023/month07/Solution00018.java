package com.fuqi.year2023.month07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/15 09:30
 * @description 四数之和
 */
public class Solution00018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) return ans;
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[0] > target) return ans;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if ((long) nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
            if ((long) nums[i] + nums[n-3] + nums[n-2] + nums[n-1] < target) continue;
            for (int j = i+1; j < n-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                if ((long) nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) break;
                if ((long) nums[i] + nums[j] + nums[n-2] + nums[n-1] < target) continue;
                int left = j+1, right = n-1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Stream.of(nums[i], nums[j], nums[left], nums[right]).collect(Collectors.toList()));
                        left++;
                        while (left < right && nums[left] == nums[left-1]) left++;
                        right--;
                        while (left < right && nums[right] == nums[right+1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}
