package com.fuqi.year2022.month01;

import java.util.Random;

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
            while (i < j && nums[j] >= base) j--;
            // 如果左边的元素小于或等于基准值，则只需移动指针即可
            while (i < j && nums[i] <= base) i++;
            // 至此，说明nums[i] > base或者nums[j] < base
            // 因此需要将i,j的元素进行交换
            if (i < j) swap(nums, i, j);
        }
        // 循环完成后，将基准值与i,j相等处的元素进行交换
        nums[left] = nums[i];
        nums[i] = base;
        // 递归排序基准值左边区域的数据
        quickSort(nums, left, i-1);
        // 递归排序基准值右边区域的数据
        quickSort(nums, i+1, right);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static final int INSERTION_SORT_THRESHOLD = 7;

    private static final Random RANDOM = new Random();

    /**
     * 双指针快排
     *
     * @param nums
     * @param left
     * @param right
     */
    private void quickSort2(int[] nums, int left, int right) {
        // 小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        // 循环不变量：
        // all in [left + 1, lt] < pivot
        // all in [lt + 1, i) = pivot
        // all in [gt, right] > pivot
        int pivot = nums[left];
        int lt = left;
        int gt = right + 1;

        int i = left + 1;
        while (i < gt) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                gt--;
                swap(nums, i, gt);
            }
        }
        swap(nums, left, lt);
        // 注意这里，大大减少了两侧分治的区间
        quickSort2(nums, left, lt - 1);
        quickSort2(nums, gt, right);
    }

    /**
     * 对数组 nums 的子区间 [left, right] 使用插入排序
     *
     * @param nums  给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution00912 solution00912 = new Solution00912();
        int[] nums = new int[]{5,1,3,2,4,9,6,7,8};
        solution00912.sortArray(nums);
        System.out.println("done");
    }

}
