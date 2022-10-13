package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/8 22:05
 * @description
 */
public class Solution00153 {
    /**
     * 暴力法：从数组第一个元素开始找到第一个小于前一个元素的元素就是最小值，否则就是整个数组的第一个元素
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                return nums[i];
            }
        }

        return nums[0];
    }

    /**
     * 二分法
     *
     * @param nums
     * @return
     */
    public static int findMin2(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = (left+right)/2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,8,0,1,2,3};
        System.out.println(findMin2(nums));
    }
}
