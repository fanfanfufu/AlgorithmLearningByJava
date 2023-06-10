package com.fuqi.year2023.month06;


import org.junit.jupiter.api.Assertions;

import java.util.*;

public class Solution0609 {
    public static List<List<Integer>> getSubCollection(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return new ArrayList<>();
        }
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int start = 0;
        backtrack(ans, path, n, start, nums);

        return ans;
    }

    public static void backtrack(List<List<Integer>> ans, Deque<Integer> path, int n, int start, int[] nums) {
        ans.add(new ArrayList<>(path));
        if (start == n) {
            // 递归终止
            return;
        }
        for (int i = start; i < n; i++) {
            path.offerLast(nums[i]);
            backtrack(ans, path, n, i+1, nums);
            path.pollLast();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] nums = new int[]{1,2,3};
        System.out.println(getSubCollection(nums).size());
        Assertions.assertEquals(32, getSubCollection(nums).size());
    }
}
