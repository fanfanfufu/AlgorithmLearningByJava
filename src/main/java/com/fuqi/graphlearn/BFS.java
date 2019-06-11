package com.fuqi.graphlearn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 广度优先搜索学习
 * @Author 傅琦
 * @Date 2019/6/7 19:56
 * @Version V1.0
 */
public class BFS {
    private static void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist, char start){
        Queue<Character> queue = new LinkedList<>();
        queue.add(start);
        dist.put(start, 0);

        int i = 0;
        while (!queue.isEmpty()){
            char top = queue.poll();
            i++;
            System.out.println("The " + i + "th element: " + top + "Distance from start is: " + dist.get(top));
            int distance = dist.get(top) + 1;
            for (Character character: graph.get(top)) {
                if (!dist.containsKey(character)){
                    dist.put(character, distance);
                    queue.add(character);
                }
            }
        }
    }
}
