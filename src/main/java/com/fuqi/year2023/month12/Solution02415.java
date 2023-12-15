package com.fuqi.year2023.month12;

import com.fuqi.year2020.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/12/15 19:57
 * @description
 */
public class Solution02415 {
    public TreeNode reverseOddLevelsBFS(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        int layerCount = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Deque<TreeNode> preLayer = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (node.left != null) {
                    deque.offerLast(node.left);
                    deque.offerLast(node.right);
                }
                if ((layerCount & 1) == 1) preLayer.offerLast(node);
            }
            layerCount++;
            while (!preLayer.isEmpty()) {
                TreeNode leftNode = preLayer.pollFirst();
                TreeNode rightNode = preLayer.pollLast();
                int temp = leftNode.val;
                leftNode.val = rightNode.val;
                rightNode.val = temp;
            }
        }

        return root;
    }

    public TreeNode reverseOddLevelsDFS(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        dfs(root.left, root.right, true);

        return root;
    }

    private void dfs(TreeNode leftNode, TreeNode rightNode, boolean isOdd) {
        if (leftNode == null || rightNode == null) return;
        if (isOdd) {
            int temp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = temp;
        }
        dfs(leftNode.left, rightNode.right, !isOdd);
        dfs(leftNode.right, rightNode.left, !isOdd);
    }
}
