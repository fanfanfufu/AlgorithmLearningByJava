package com.fuqi.year2022.month12;

import java.util.*;

/**
 * @author FuQi
 * @date 2022/12/4 11:11
 * @description
 */
public class Solution06255 {
    /**
     * 临界矩阵会超出内存限制
     *
     * @param n
     * @param roads
     * @return
     */
    public int minScore(int n, int[][] roads) {
        // 1. 建立图，临界表的方式
        int[][] graph = new int[n+1][n+1];
        for (int[] road : roads) {
            graph[road[0]][road[1]] = road[2];
            graph[road[1]][road[0]] = road[2];
        }
        // 2. 遍历图，找出每条路径中的最小分数
        boolean[] visited = new boolean[n+1];
        int ans = Integer.MAX_VALUE;
        Deque<Integer> path = new LinkedList<>();
        path.offerLast(1);
        visited[1] = true;
        while (!path.isEmpty()) {
            int curRow = path.pollFirst();
            for (int i = 1; i < graph[curRow].length; i++) {
                int curCell = graph[curRow][i];
                if (curCell == 0) {
                    continue;
                }
                ans = Math.min(ans, curCell);
                if (!visited[i]) {
                    path.offerLast(i);
                    visited[i] = true;
                }
            }
        }

        return ans;
    }


    public int minScore2(int n, int[][] roads) {
        // 创建图，不能使用邻接矩阵，否则判题器会判断内存不够
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] r : roads) {
            Map<Integer, Integer> tmp = graph.getOrDefault(r[0], new HashMap<>());
            tmp.put(r[1], r[2]);
            graph.put(r[0], tmp);
            tmp = graph.getOrDefault(r[1], new HashMap<>());
            tmp.put(r[0], r[2]);
            graph.put(r[1], tmp);
        }
        // 遍历图，找到联通块的边的最小值即可
        int ans = Integer.MAX_VALUE;
        boolean[] union = new boolean[n+1];
        Deque<Integer> path = new LinkedList<>();
        path.offerLast(1);
        union[1] =true;
        while (!path.isEmpty()) {
            // 取出当前顶点及其邻居顶点和对应边的距离
            int cur = path.pollFirst();
            Map<Integer, Integer> neighbors = graph.get(cur);
            // 遍历邻居顶点
            for (Map.Entry<Integer, Integer> neighbor : neighbors.entrySet()) {
                // 比较大小
                ans = Math.min(ans, neighbor.getValue());
                // 如果当前邻居已经是连通区域内的顶点，则直接跳过
                if (union[neighbor.getKey()]) continue;
                // 否则将当前邻居顶点添加到联通区域中
                path.offerLast(neighbor.getKey());
                // 标记当前邻居顶点已经加入联通区域当中
                union[neighbor.getKey()] = true;
            }
        }

        return ans;
    }
}
