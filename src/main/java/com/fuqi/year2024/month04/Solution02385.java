package com.fuqi.year2024.month04;

import com.fuqi.year2020.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/4/24 22:56
 * @description 感染二叉树需要的总时间
 */
public class Solution02385 {
    private TreeNode startNode;
    private final Map<TreeNode, TreeNode> preNodeMap = new HashMap<>();
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, null, start);
        return maxDepth(startNode, startNode);
    }

    private int maxDepth(TreeNode node, TreeNode from) {
        if (node == null) return -1;
        int ans = -1;
        if (node.left != from) ans = Math.max(ans, maxDepth(node.left, node));

        if (node.right != from) ans = Math.max(ans, maxDepth(node.right, node));

        if (preNodeMap.get(node) != from) ans = Math.max(ans, maxDepth(preNodeMap.get(node), node));

        return ans+1;
    }

    private void dfs(TreeNode node, TreeNode from, int start) {
        if (node == null) {
            return;
        }
        preNodeMap.put(node, from);
        if (node.val == start) startNode = node;
        dfs(node.left, node, start);
        dfs(node.right, node, start);
    }
}
