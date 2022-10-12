package com.fuqi.sortAlig;

/**
 * @Description: 堆排序
 * @Author 傅琦
 * @Date 2019/6/5 20:36
 * @Version V1.0
 */
public class HeapOrder {
    private static void order(int[] arr) {
        // 1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 2.调整对结构+交换堆顶与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    private static void adjustHeap(int[] arr, int i, int len) {
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int j = i * 2 + 1; j < len; j = 2 * j + 1) {
            //如果左子结点小于右子结点，j指向右子结点
            if (j + 1 < len && arr[j] < arr[j + 1]) {
                j++;
            }

            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        //将temp值放到最终的位置
        arr[i] = temp;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        heapify(nums);
        for (int i = len - 1; i >= 1; ) {
            swap(nums, 0, i);
            i--;
            siftDown(nums, 0, i);
        }

        return nums;
    }

    private void heapify(int[] nums) {
        int len = nums.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    private void siftDown(int[] nums, int k, int end) {
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[j] > nums[k]) {
                swap(nums, j, k);
            } else {
                break;
            }
            k = j;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        order(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
