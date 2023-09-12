package com.fuqi.year2023.month09;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/9/12 22:49
 * @description
 */
public class Solution01462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        if (numCourses == 1) {
            ans.add(true);
            return ans;
        }
        // 创建入度表
        int[] indegress = new int[numCourses];
        // 创建邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 统计每门课程的入度与邻接课程
        for (int[] prerequire : prerequisites) {
            indegress[prerequire[1]]++;
            adjacency.get(prerequire[0]).add(prerequire[1]);
        }
        // 将所有入度为0的顶点添加到队列中
        for (int i = 0; i < numCourses; i++) {
            if (indegress[i] == 0) deque.offerLast(i);
        }
        // isPre[x][y]表示x是否是y的直接或间接先决条件
        boolean[][] isPre = new boolean[numCourses][numCourses];

        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();
            for (int next : adjacency.get(cur)) {
                isPre[cur][next] = true;
                for (int i = 0; i < numCourses; i++) {
                    isPre[i][next] = isPre[i][next] | isPre[i][cur];
                }
                indegress[next]--;
                if (indegress[next] == 0) deque.offerLast(next);
            }
        }

        for (int[] query : queries) {
            ans.add(isPre[query[0]][query[1]]);
        }

        return ans;
    }
}
