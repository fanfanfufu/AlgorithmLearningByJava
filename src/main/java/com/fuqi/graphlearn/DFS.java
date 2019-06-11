package com.fuqi.graphlearn;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Description: 深度优先搜索
 * @Author 傅琦
 * @Date 2019/6/7 20:25
 * @Version V1.0
 */
public class DFS {
    /**
     * 全局变量count记录了进入每个节点和离开每个节点的时间
     */
    private static int count = 0;
    private static void dfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Boolean> visited){
        visit(graph, visited, 'u');
        visit(graph, visited, 'w');
    }

    private static void visit(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Boolean> visited, char start){
        if (!visited.containsKey(start)){
            count++;
            System.out.println("The time into element " + start + ": " + count);
            for (char ch: graph.get(start)) {
                if (!visited.containsKey(ch)){
                    // 递归访问当前节点的相邻节点
                    visit(graph, visited, ch);
                }
            }
            count++;
            System.out.println("The time out the element " + start + ": " + count);
        }
    }
}
