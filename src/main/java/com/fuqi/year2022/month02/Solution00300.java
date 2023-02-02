package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/26 22:40
 * @description
 */
public class Solution00300 {
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int[] dp = new int[len];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 如果i大于j，则说明j处的子序列可以再延长一位
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public int lengthOfLIS1(int[] nums) {
        int ans = 0;
        int[] tails = new int[nums.length];
        for (int num : nums) {
            int i = 0, j = ans;
            while (i < j) {
                int mid = (i + j) / 2;
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (ans == j) {
                ans++;
            }
        }

        return ans;
    }

    public static int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        int[] tails = new int[len];
        tails[0] = nums[0];
        int end = 0;

        for (int i = 1; i < len; i++) {
            if (tails[end] < nums[i]) {
                end++;
                tails[end] = nums[i];
                continue;
            }
            int left = 0;
            int right = end;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = nums[i];
        }
        end++;

        return end;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18, 4, 8, 6, 12};
        System.out.println(lengthOfLIS2(nums));
    }
}
