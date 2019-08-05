package com.fuqi.month08.day0804;

/**
 * @Description: 递减元素使数组呈锯齿状
 *
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 *
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 *
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都小于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 *
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 *
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 *
 * @Author: 傅琦
 * @DateTime: 2019/8/4 10:32
 * @Version: V1.0
 */
public class Exam08041 {
    public static void main(String[] args) {
        Exam08041 exam08041 = new Exam08041();
        int[] input = {9,6,1,6,2};
        int res = exam08041.movesToMakeZigzag(input);
        System.out.println("res = " + res);
    }

    public int movesToMakeZigzag(int[] nums) {
        int evenRes = 0;
        int oddRes = 0;
        int left;
        int right;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                left = Integer.MAX_VALUE;
            }else {
                left = nums[i-1];
            }

            if (i == nums.length-1){
                right = Integer.MAX_VALUE;
            }else {
                right = nums[i+1];
            }

            int minNum = Math.min(left, right);

            if (i % 2 == 0){
                if (nums[i] >= minNum){
                    evenRes += nums[i] - minNum + 1;
                }
            }else {
                if (nums[i] >= minNum){
                    oddRes += nums[i] - minNum + 1;
                }
            }
        }

        return Math.min(oddRes, evenRes);
    }
}
