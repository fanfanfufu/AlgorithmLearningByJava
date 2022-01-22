package com.fuqi.year2022.month01;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author FuQi
 * @date 2022/1/22 15:11
 * @description
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

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest2(nums, k));
    }
}
