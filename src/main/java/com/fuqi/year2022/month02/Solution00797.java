package com.fuqi.year2022.month02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/2/14 23:10
 * @description
 */
public class Solution00797 {
    private List<List<Integer>> ans = new ArrayList<>();
    private Deque<Integer> stack = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length-1);

        return ans;
    }

    private void dfs(int[][] graph, int i, int n) {
        if (i == n) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int j : graph[i]) {
            stack.offerLast(j);
            dfs(graph, j, n);
            stack.pollLast();
        }
    }
}
