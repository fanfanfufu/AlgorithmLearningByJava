package com.fuqi.year2022.month07;

import com.fuqi.year2020.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/7/11 23:42
 * @description 对称二叉树
 */
public class Solution00101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        deque.offerLast(root);

        while (!deque.isEmpty()) {
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollFirst();
            if (left == null && right == null) { continue; }
            if (left == null || right == null) { return false; }
            if (left.val != right.val) { return false; }

            deque.offerLast(left.left);
            deque.offerLast(right.right);
            deque.offerLast(left.right);
            deque.offerLast(right.left);
        }

        return true;
    }
}
