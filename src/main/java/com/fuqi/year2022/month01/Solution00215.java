package com.fuqi.year2022.month01;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author FuQi
 * @date 2022/1/22 15:11
 * @description 数组中的第K个最大元素
 */
public class Solution00215 {
    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 小顶堆
        Queue<Integer> smallHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (smallHeap.size() < k) {
                smallHeap.offer(num);
                continue;
            }
            if (smallHeap.peek() < num) {
                smallHeap.poll();
                smallHeap.offer(num);
            }
        }

        return smallHeap.peek();
    }

    public static int findKthLargest2(int[] nums, int k) {
        List<Integer> sortedNums = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        return sortedNums.get(k-1);
    }

    private final static  Random random = new Random(System.currentTimeMillis());

    public int findKthLargest3(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0, right = len - 1;
        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;
        while (true) {
            while (le <= ge && nums[le] < pivot) le++;
            while (le <= ge && nums[ge] > pivot) ge--;
            if (le >= ge) break;
            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);

        return ge;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest2(nums, k));
    }
}
