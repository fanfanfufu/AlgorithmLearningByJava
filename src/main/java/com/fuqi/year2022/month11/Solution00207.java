package com.fuqi.year2022.month11;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/11/20 21:44
 * @description
 */
public class Solution00207 {
    /**
     * BFS
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinishBfs(int numCourses, int[][] prerequisites) {
        // 创建入度表
        int[] indegress = new int[numCourses];
        // 创建邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 统计没门课程的入读与邻接课程
        for (int[] cp : prerequisites) {
            indegress[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // 将所有入度为0的顶点添加到队列中
        for (int i = 0; i < numCourses; i++) {
            if (indegress[i] == 0) {
                deque.offerLast(i);
            }
        }
        // BFS
        while (!deque.isEmpty()) {
            int pre = deque.pollFirst();
            numCourses--;
            // 遍历当前节点的出度节点
            for (int cur : adjacency.get(pre)) {
                // 减去对应顶点的入度
                indegress[cur]--;
                if (indegress[cur] == 0) {
                    deque.offerLast(cur);
                }
            }
        }

        return numCourses == 0;
    }

    /**
     * DFS
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinishDfs(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites) {
            adjacency.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) { return false; }
        // flags[i] == -1 说明当前顶点的后续顶点已经遍历完毕
        if (flags[i] == -1) { return true; }
        flags[i] = 1;
        for (int j : adjacency.get(i)) {
            if (!dfs(adjacency, flags, j)) {
                return false;
            }
        }
        flags[i] = -1;

        return true;
    }
}
