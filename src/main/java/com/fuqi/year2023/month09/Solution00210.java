package com.fuqi.year2023.month09;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/9/10 17:51
 * @description
 */
public class Solution00210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) return new int[]{0};
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
            indegress[prerequire[0]]++;
            adjacency.get(prerequire[1]).add(prerequire[0]);
        }
        // 将所有入度为0的顶点添加到队列中
        for (int i = 0; i < numCourses; i++) {
            if (indegress[i] == 0) deque.offerLast(i);
        }

        int[] ans = new int[numCourses];
        int index = 0;
        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();
            ans[index] = cur;
            index++;
            for (int v : adjacency.get(cur)) {
                indegress[v]--;
                if (indegress[v] == 0) deque.offerLast(v);
            }
        }

        if (index != numCourses) return new int[0];

        return ans;
    }
}
