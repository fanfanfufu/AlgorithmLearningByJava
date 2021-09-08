package com.fuqi.year2021.month09.day20210908;

import com.fuqi.year2020.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 */
public class AvgTree {
    public boolean isSymmetricDFS(TreeNode root) {
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

        return isMirror(left.left, left.right) && isMirror(right.left, right.right);
    }

    public boolean isSymmetricBFS(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.poll();
            TreeNode right = deque.poll();
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            // 执行到这里说明当前的两个节点是镜像的，需要比较他们的子节点
            // 注意入队顺序
            deque.offer(left.left);
            deque.offer(right.right);
            // 第二组
            deque.offer(left.right);
            deque.offer(right.left);
        }

        return true;
    }

}
