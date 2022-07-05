package com.fuqi.year2022.month07;

import com.fuqi.year2020.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author FuQi
 * @date 2022/7/5 23:11
 * @description
 */
public class Solution00104 {
    public int maxDepth(TreeNode root) {
        return dfs(0, root);
    }

    private int dfs(int depth, TreeNode root) {
        if (root == null) {
            return depth;
        }
        int leftDepth = dfs(depth + 1, root.left);
        int rightDepth = dfs(depth+1, root.right);

        return Math.max(leftDepth, rightDepth);
    }

    private int bfs (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int curLen = deque.size();
            for (int i = 0; i < curLen; i++) {
                TreeNode curNode = deque.pollFirst();
                if (curNode.left != null) {
                    deque.offerLast(curNode.left);
                }
                if (curNode.right != null) {
                    deque.offerLast(curNode.right);
                }
            }
            depth++;
        }

        return depth;
    }
}
