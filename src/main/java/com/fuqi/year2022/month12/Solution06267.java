package com.fuqi.year2022.month12;

import java.util.*;

/**
 * @author FuQi
 * @date 2022/12/18 21:49
 * @description
 */
public class Solution06267 {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        // 1. 遍历边数组，构造邻接表于统计每个顶点的度
        // 1.1 每个顶点的度数数组
        int[] degree = new int[n+1];
        // 1.2 邻接表，key为顶点，value为于key相邻的顶点
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (List<Integer> edge : edges) {
            int a = edge.get(0);
            int b = edge.get(1);
            degree[a]++;
            degree[b]++;
            if (!graph.containsKey(a)) {
                graph.put(a, new HashSet<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new HashSet<>());
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // 2. 找出度数为计数的点
        int m = 0;
        int[] odds = new int[4];
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 0) continue;
            // 如果超过4个顶点的度为奇数，则结果不可能为true
            if (m > 3) return false;
            odds[m] = i;
            m++;
        }
        // 3. 根据m的个数进行处理
        if (m == 0) return true;
        if (m == 2) {
            int a = odds[0];
            int b = odds[1];
            // 3.1 判断这两个点是不是一条边上的两个点（即它们是否已经相连了）
            if (!graph.get(a).contains(b)) {
                // a相邻（相连）的顶点中没有b，则a和b可以通过补充一条连线的方式相连，从而满足题目要求，可以返回true
                return true;
            }
            // 若a和b在同一条边上：
            // 则需要遍历邻接表，找是否有点既不与a相连，又不与b相连
            // 这样的点可以通过补两条边，分别连接a，b，从而满足题目要求所有的点度数为偶数，可以返回true
            for (int i = 1; i <= n; i++) {
                if (!graph.get(a).contains(i) && !graph.get(b).contains(i)) {
                    return true;
                }
            }
            return false;
        }
        // 当有四个顶点的度数为奇数时
        // 则需要找这四个点满足任意两组不相连
        if (m == 4) {
            int a = odds[0];
            int b = odds[1];
            int c = odds[2];
            int d = odds[3];
            if (!graph.get(a).contains(b) && !graph.get(c).contains(d)) return true;
            if (!graph.get(a).contains(c) && !graph.get(b).contains(d)) return true;
            if (!graph.get(a).contains(d) && !graph.get(b).contains(c)) return true;
        }
        // 其余情况都返回false
        return false;
    }
}
