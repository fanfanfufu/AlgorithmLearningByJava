package com.fuqi.year2021.month09.day20210908;

import com.fuqi.year2020.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FuQi
 */
public class PathSum {
    public boolean hasPathSumBFS(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<Integer> sumQue = new LinkedList<>();
        deque.offer(root);
        sumQue.offer(root.val);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.poll();
            Integer curSum = sumQue.poll();
            if (cur.left == null && cur.right == null) {
                if (targetSum == curSum) {
                    return true;
                }
                continue;
            }
            if (cur.left != null) {
                deque.offer(cur.left);
                int temp = curSum + cur.left.val;
                sumQue.offer(temp);
            }
            if (cur.right != null) {
                deque.offer(cur.right);
                int temp = curSum + cur.right.val;
                sumQue.offer(temp);
            }
        }

        return false;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
