package com.fuqi.year2022.month10;

import com.fuqi.year2020.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author FuQi
 * @date 2022/10/10 23:15
 * @description
 */
public class Solution00662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        return bfs(root);
        return dfs(root, 1, 1);
    }

    // 存储每层最小的索引
    private Map<Integer, Integer> levelMin = new HashMap<>();

    private int dfs(TreeNode root, int depth, int index) {
        if (root == null) {
            return 0;
        }
        levelMin.putIfAbsent(depth, index);

        return Math.max(index - levelMin.get(depth) + 1,
                Math.max(dfs(root.left, depth + 1, index * 2), dfs(root.right, depth + 1, index * 2 + 1)));
    }

    private int bfs(TreeNode root) {
        int width = 0;
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        Deque<Integer> nodeIndexDeque = new LinkedList<>();
        nodeDeque.offerLast(root);
        nodeIndexDeque.offerLast(1);
        while (!nodeDeque.isEmpty()) {
            int size = nodeDeque.size();
            int curLayerWidth = 0;
            boolean firstNodeFlag = false;
            int left = -1, right = -1;
            while (size-- > 0) {
                TreeNode curNode = nodeDeque.pollFirst();
                int curNodeIndex = nodeIndexDeque.pollFirst();
                if (!firstNodeFlag) {
                    firstNodeFlag = true;
                    left = curNodeIndex;
                }
                right = curNodeIndex;
                curLayerWidth = Math.max(curLayerWidth, right - left + 1);
                if (curNode.left != null) {
                    nodeDeque.offerLast(curNode.left);
                    nodeIndexDeque.offerLast(curNodeIndex * 2);
                }
                if (curNode.right != null) {
                    nodeDeque.offerLast(curNode.right);
                    nodeIndexDeque.offerLast(curNodeIndex * 2 + 1);
                }
            }
            width = Math.max(width, curLayerWidth);
        }

        return width;
    }
}
