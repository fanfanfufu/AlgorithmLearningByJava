package com.fuqi.year2023.month05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/14 21:50
 * @description
 */
public class Solution00216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        int start = 9;

        dfs(start, k, n, path, ans);

        return ans;
    }

    private void dfs(int start, int k, int target, Deque<Integer> path, List<List<Integer>> ans) {
        int d = k - path.size();
        if (target < 0 || target > ((2 * start - d + 1) * d / 2)) return;
        if (path.size() == k) {
            // 这里无需再判断target==0的情况
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i >= d; i--) {
            path.offerLast(i);
            dfs(i-1, k, target-i, path, ans);
            path.pollLast();
        }
    }
}
