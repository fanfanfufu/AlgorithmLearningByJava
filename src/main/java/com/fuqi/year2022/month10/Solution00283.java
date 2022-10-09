package com.fuqi.year2022.month10;

/**
 * @author FuQi
 * @date 2022/10/9 23:42
 * @description
 */
public class Solution00283 {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            // 非零时i, j都前进
            if (nums[i] != 0) {
                i++;
                j++;
                continue;
            }
            while (i < nums.length) {
                if (nums[i] == 0) {
                    i++;
                    continue;
                }
                swap(i, j, nums);
                break;
            }
            // 交换完之后, j往前走一位
            j++;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
