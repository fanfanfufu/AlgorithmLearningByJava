package com.fuqi.year2019.month07.day0721;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/7/21 10:28
 * @Version: V1.0
 */
public class Exam2 {
    int n;

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        this.n = n;
        // 构造图
        List<List<Integer>> rGraph = new ArrayList<>();
        build(rGraph, red_edges);
        List<List<Integer>> bGraph = new ArrayList<>();
        build(bGraph, blue_edges);

        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = dist[1][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        queue.add(new int[] {0, 1});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            if (cur[1] == 0){
                for (int u : rGraph.get(cur[0])) {
                    if (dist[1][u] == Integer.MAX_VALUE){
                        dist[1][u] = dist[cur[1]][cur[0]]+1;
                        queue.add(new int[] {u, 1});
                    }
                }
            }else {
                for (int u : bGraph.get(cur[0])) {
                    if (dist[0][u] == Integer.MAX_VALUE){
                        dist[0][u] = dist[cur[1]][cur[0]]+1;
                        queue.add(new int[] {u, 0});
                    }
                }
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.min(dist[0][i], dist[1][i]);
            if (ans[i] == Integer.MAX_VALUE){
                ans[i] = -1;
            }
        }
        return ans;
    }

    /**
     * 构造图
     * @param graph
     * @param edges
     */
    void build(List<List<Integer>> graph, int[][] edges){
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
        }
    }
}
