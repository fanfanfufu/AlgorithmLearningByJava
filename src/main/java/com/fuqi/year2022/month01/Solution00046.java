package com.fuqi.year2022.month01;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/1/15 18:59
 * @description
 */
public class Solution00046 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, path, used, ans);

        return ans;
    }

    private void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> ans) {
        if (depth == nums.length) {
            // 终止条件，当深度与输入长度相同时，说明已经用所有数字排列了一遍了，因此终止循环
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.offerFirst(nums[i]);
            used[i] = true;
            dfs(nums, depth+1, path, used, ans);
            used[i] = false;
            path.pollFirst();
        }
    }
}
