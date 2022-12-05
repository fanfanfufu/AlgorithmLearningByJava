package com.fuqi.year2022.month02;

import java.util.*;

/**
 * @author FuQi
 * @date 2022/2/16 22:15
 * @description
 */
public class Solution00047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);

        dfs(nums, 0, path, ans, used);

        return ans;
    }

    private void dfs(int[] nums, int depth, Deque<Integer> path, List<List<Integer>> ans, boolean[] used) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, depth+1, path, ans, used);
            used[i] = false;
            path.pollLast();
        }
    }

    public static void main(String[] args) {
        Solution00047 solution00047 = new Solution00047();
        int[] nums = new int[]{1,2,1};
        System.out.println(solution00047.permuteUnique(nums));
    }
}
