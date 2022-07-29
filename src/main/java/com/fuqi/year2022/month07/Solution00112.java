package com.fuqi.year2022.month07;

import com.fuqi.year2020.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author FuQi
 * @date 2022/7/29 23:30
 * @description
 */
public class Solution00112 {
    /**
     * DFS
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                return true;
            }
            return false;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSumBFS(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<Integer> sumQue = new ArrayDeque<>();
        deque.offerLast(root);
        sumQue.offerLast(root.val);
        while (!deque.isEmpty()) {
            TreeNode curNode = deque.pollFirst();
            Integer curSum = sumQue.pollFirst();
            if (curNode.left == null && curNode.right == null) {
                if (curSum == targetSum) {
                    return true;
                }
                continue;
            }
            if (curNode.left != null) {
                deque.offerLast(curNode.left);
                sumQue.offerLast(curSum + curNode.left.val);
            }
            if (curNode.right != null) {
                deque.offerLast(curNode.right);
                sumQue.offerLast(curNode.right.val + curSum);
            }
        }

        return false;
    }
}
