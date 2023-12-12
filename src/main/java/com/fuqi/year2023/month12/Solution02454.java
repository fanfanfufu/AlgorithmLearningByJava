package com.fuqi.year2023.month12;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/12/12 21:29
 * @description
 */
public class Solution02454 {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // 存的是当前元素的往后的第一个更大的元素的下标
        Deque<Integer> stack1 = new ArrayDeque<>();
        // 存的是当前元素往后的第二个更大元素的下标
        Deque<Integer> stack2 = new ArrayDeque<>();
        //
        Deque<Integer> transfer = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack2.isEmpty() && nums[stack2.peek()] < nums[i]) {
                ans[stack2.pop()] = nums[i];
            }
            while (!stack1.isEmpty() && nums[stack1.peek()] < nums[i]) {
                transfer.push(stack1.pop());
            }
            stack1.push(i);
            while (!transfer.isEmpty()) {
                stack2.push(transfer.pop());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution02454 solution02454 = new Solution02454();
        int[] nums = {2,4,0,9,6};
        int[] res = solution02454.secondGreaterElement(nums);
        Arrays.stream(res).forEach(System.out::println);
    }
}
