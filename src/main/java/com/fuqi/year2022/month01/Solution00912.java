package com.fuqi.year2022.month01;

/**
 * @author FuQi
 * @date 2022/1/23 20:43
 * @description
 */
public class Solution00912 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int left = 0, right = nums.length-1;
        quickSort(nums, left, right);
        return nums;
    }

    /**
     * 使用递归的方式实现快排
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private void quickSort(int[] nums, int left, int right) {
        // 终止条件
        if (left >= right) {
            return;
        }
        // 随便取一个属做基准值
        int base = nums[left];
        int i = left, j = right;
        while (i < j) {
            // 需要先处理右边的元素
            // 右边的元素大于或等于基准值，则移动指针即可
            while (i < j && nums[j] >= base) {
                j--;
            }
            // 如果左边的元素小于或等于基准值，则只需移动指针即可
            while (i < j && nums[i] <= base) {
                i++;
            }
            // 至此，说明nums[i] > base或者nums[j] < base
            // 因此需要将i,j的元素进行交换
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        // 循环完成后，将基准值与i,j相等处的元素进行交换
        nums[left] = nums[i];
        nums[i] = base;
        // 递归排序基准值左边区域的数据
        quickSort(nums, left, i-1);
        // 递归排序基准值右边区域的数据
        quickSort(nums, i+1, right);
    }

    public static void main(String[] args) {
        Solution00912 solution00912 = new Solution00912();
        int[] nums = new int[]{5,1,3,2,4,9,6,7,8};
        solution00912.sortArray(nums);
        System.out.println("done");
    }

}
