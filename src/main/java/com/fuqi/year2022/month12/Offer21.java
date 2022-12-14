package com.fuqi.year2022.month12;

/**
 * @author FuQi
 * @date 2022/12/14 22:58
 * @description 调整数组顺序使奇数位于偶数前面
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }
}
