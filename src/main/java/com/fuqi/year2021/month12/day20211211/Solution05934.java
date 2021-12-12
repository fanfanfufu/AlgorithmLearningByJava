package com.fuqi.year2021.month12.day20211211;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author FuQi
 * @date 2021/12/11 22:34
 * @description
 */
public class Solution05934 {
    public static int[] maxSubsequence(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        // 采用小顶堆：最小的数在最顶上，每次poll()得到的就是最小的数，或者说pee()就是最小的数据
        PriorityQueue<Num> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        for (int i = 0; i < k; i++) {
            Num num = new Num(i, nums[i]);
            minHeap.offer(num);
        }

        for (int i = k; i < nums.length; i++) {
            Num peek = minHeap.peek();
            if (peek.value < nums[i]) {
                // 若当前数大于堆中最小的数，则将当前数添加进堆中，并移除堆顶元素
                Num num = new Num(i, nums[i]);
                minHeap.offer(num);
                minHeap.poll();
            }
        }

        int[] ans = new int[k];
        // 为了保证输出的数组的顺序尽量与原数组的顺序一直
        List<Num> numList = minHeap.stream().sorted(Comparator.comparingInt(o -> o.index)).collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            ans[i] = numList.get(i).value;
        }

        return ans;
    }

    /**
     * 定义一个类，同时记录一个数的值和下标
     */
    static class Num {
        public int index;

        public int value;

        public Num() {
        }

        public Num(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {2,1,3,3};
        int[] nums = new int[] {63,-74,61,-17,-55,-59,-10,2,-60,-65};
//        int[] nums = new int[] {2,1,3,3,-5,-9,25,-33,-21};
        int k = 2;
        int[] ans = maxSubsequence(nums, k);
        Arrays.stream(ans).forEach(System.out::println);
    }
}
