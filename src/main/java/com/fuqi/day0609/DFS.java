package com.fuqi.day0609;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/6/9 12:10
 * @Version: V1.0
 */
public class DFS {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(results, new ArrayList<Integer>(), used, nums);
        return results;
    }
    private void dfs(List<List<Integer>> results, List<Integer> cur, boolean[] used, int[] nums) {
        if (cur.size() == nums.length) {
            results.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            cur.add(nums[i]);
            dfs(results, cur, used, nums);
            used[i] = false;
            cur.remove(cur.size() -1);
        }
    }
}
