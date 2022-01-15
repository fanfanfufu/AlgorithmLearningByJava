package com.fuqi.year2022.month01;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/1/15 16:41
 * @description
 */
public class Solution00077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(n, k, 1, path, ans);

        return ans;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> ans) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.add(i);
            dfs(n,k,i+1,path,ans);
            // 移除掉上一步添加进队列中最后的元素
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution00077 solution = new Solution00077();
        solution.combine(4, 2);
    }
}
