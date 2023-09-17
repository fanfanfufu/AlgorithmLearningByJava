package com.fuqi.year2023.month09;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/9/16 23:46
 * @description
 */
public class Solution1000041 {
    int[] ans;
    Tree[] trees;
    int cnt = 0;

    public int[] minEdgeReversals(int n, int[][] edges) {
        ans = new int[n];
        trees = new Tree[n];
        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree();
        }
        for (int[] edge : edges) {
            trees[edge[0]].child.put(edge[1], true);
            trees[edge[1]].child.put(edge[0], false);
        }
        build(0, 0);
        dfs1(0);
        dfs(0, cnt);
        return ans;
    }

    private void dfs1(int v) {
        for (Map.Entry<Integer, Boolean> entry : trees[v].child.entrySet()) {
            Integer w = entry.getKey();
            Boolean d = entry.getValue();
            if (!d) {
                cnt++;
            }
            dfs1(w);
        }
    }

    private void dfs(int v, int c) {
        ans[v] = c;
        for (Map.Entry<Integer, Boolean> entry : trees[v].child.entrySet()) {
            Integer w = entry.getKey();
            Boolean d = entry.getValue();
            dfs(w, c + (d ? 1 : -1));
        }
    }

    private void build(int v, int p) {
        trees[v].child.remove(p);
        for (Integer w : trees[v].child.keySet()) {
            build(w, v);
        }
    }
}

class Tree {
    Map<Integer, Boolean> child = new HashMap<>();
}
