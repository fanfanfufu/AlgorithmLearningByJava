package com.fuqi.year2022.month11;

import com.fuqi.year2020.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/11/20 22:56
 * @description
 */
public class Solution00958 {

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public boolean isCompleteTreeBfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        boolean hasNull = false;
        while (!deque.isEmpty()) {
            TreeNode cur = deque.pollFirst();
            if (hasNull && cur != null) {
                return false;
            }
            if (cur == null) {
                hasNull = true;
                continue;
            }
            deque.offerLast(cur.left);
            deque.offerLast(cur.right);
        }

        return true;
    }
}
