package com.fuqi.month06.day0610;

/**
 * @Description: 找到和最大的连续子数组
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * @Author 傅琦
 * @Date 2019/6/11 16:45
 * @Version V1.0
 */
public class MaximumSubarray {
    private static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }

//        int[] record = new int[nums.length];
//        record[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            record[i] = nums[i] + record[i-1];
//        }
//
//        int res = record[0];
//        for (int i = 1; i < record.length-1; i++) {
//            for (int j = i+1; j < record.length; j++) {
//                res = Math.max(res, record[j] - record[i-1]);
//            }
//        }
//        return res;

        int totalSum, currSum;
        totalSum = currSum = nums[0];

        for(int i=1; i < nums.length; i++){
            // the maximum value between [1, i]
            currSum = Math.max(nums[i], currSum + nums[i]);
            // the maximum value in all
            totalSum = Math.max(totalSum, currSum);
        }

        return totalSum;
    }

    public static void main(String[] args){
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(input);
        System.out.print(res);
    }
}
