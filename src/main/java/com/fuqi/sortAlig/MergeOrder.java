package com.fuqi.sortAlig;

/**
 * @Description: 归并排序
 * @Author 傅琦
 * @Date 2019/6/4 15:59
 * @Version V1.0
 */
public class MergeOrder {
    private static int[] order(int[] nums, int low, int high){
        int mid = (low + high) / 2;
        if (low < high){
            order(nums, low, mid);
            order(nums, mid+1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
        return nums;
    }

    private static void merge(int[] nums, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high){
            if (nums[i] < nums[j]){
                temp[k] = nums[i];
                i++;
            }else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        while (i <= mid){
            temp[k] = nums[i];
            k++;
            i++;
        }

        while (j <= high){
            temp[k] = nums[j];
            k++;
            j++;
        }

        for (int l = 0; l < temp.length; l++) {
            nums[low + l] = temp[l];
        }
    }

    public static void main(String[] args){
        int[] numbers = {36, 22, 57, 8, 3, 65, 15, 49, 100, 1, 2, 6, 8};
        int high = numbers.length - 1;
        numbers = order(numbers, 0, high);
        for (int num: numbers) {
            System.out.print(num + " ");
        }
    }
}
