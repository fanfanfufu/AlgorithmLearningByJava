package com.fuqi.year2023.month02;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2023/2/27 21:49
 * @description
 */
public class Solution02574 {
    public int[] leftRigthDifference2(int[] nums) {
        if (nums == null || nums.length < 2) return new int[]{0};
        int len = nums.length;
        int[] leftSum = new int[len];
        int[] rightSum = new int[len];
        for (int i = 1; i < len; i++) {
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }
        for (int i = len-2; i >= 0; i--) {
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = Math.abs(rightSum[i] - leftSum[i]);
        }

        return ans;
    }

    public int[] leftRigthDifference(int[] nums) {
        if (nums == null || nums.length < 2) return new int[]{0};
        int rightSum = Arrays.stream(nums).sum();
        int leftSum = 0;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 遍历到当前数字时，后缀和一定要先减去当前数字
            rightSum -= nums[i];
            // 然后计算差值
            ans[i] = Math.abs(rightSum - leftSum);
            // 差值计算完之后，就要处理下一个数字，因此前缀和要提前加上当前数字
            leftSum += nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution02574 solution02574 = new Solution02574();
        int[] nums = new int[]{10,4,8,3};
        solution02574.leftRigthDifference(nums);
    }
}
