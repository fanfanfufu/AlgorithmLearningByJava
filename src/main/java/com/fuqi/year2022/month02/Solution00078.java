package com.fuqi.year2022.month02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/2/15 20:47
 * @description 自己
 */
public class Solution00078 {
    Deque<Integer> deque = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();

    /**
     * 方法一：递归
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);

        return ans;
    }

    private void dfs(int i, int[] nums) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(deque));
            return;
        }
        deque.offerLast(nums[i]);
        dfs(i+1, nums);
        deque.pollLast();
        dfs(i+1, nums);
    }

    /**
     * 方法二：二进制枚举
     * 因为此题所有结果的数量之和刚好是(2^nums.length) - 1
     * 并且所有的枚举可以看作是对应位的数字是否被选中(即对应位是否为1)
     * 并且 1 <= nums.length <= 10
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        int n = nums.length;
        int limit = 1 << n;
        List<List<Integer>> ans = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    temp.add(nums[j]);
                }
            }
            ans.add(temp);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution00078 solution00078 = new Solution00078();
        List<List<Integer>> subsets = solution00078.subsets2(nums);
        System.out.println("done");
    }
}
