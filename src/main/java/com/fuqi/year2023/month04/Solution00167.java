package com.fuqi.year2023.month04;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/12 21:52
 * @description 两数之和二——输入有序数组
 */
public class Solution00167 {
    /**
     * 相向双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                break;
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{left+1, right+1};
    }
}
