package com.fuqi.year2022.month12;

/**
 * @author FuQi
 * @date 2022/12/19 21:59
 * @description
 */
public class Solution00075 {
    /**
     * 三指针：x，y，z
     * x从左往右移动，z从右往左移动，直到相遇
     *
     * 通过交换值确保：
     * y指针左边的元素都为0
     * y于x之间的元素都为1
     * z指针右边的元素都为2
     *
     * @param nums
     */
    public void sortColors1(int[] nums) {
        int x = 0, y = 0, z = nums.length - 1;
        while (x <= z) {
            // 1. z从右往左移动保证z右边的元素都为2
            while (x <= z && nums[x] == 2) {
                int temp = nums[x];
                nums[x] = nums[z];
                nums[z] = temp;
                z--;
            }
            // 2. 此时再看x, 将0交换到y指针下，保证y于x之间的元素均为1，以及y左边的元素都为0
            if (nums[x] == 0) {
                int temp = nums[x];
                nums[x] = nums[y];
                nums[y] = temp;
                y++;
            }
            x++;
        }
    }

    public void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                p0++;
                p1++;
            }
        }
    }
}
