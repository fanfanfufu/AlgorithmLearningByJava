package com.fuqi.year2022.month11;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/11/20 22:56
 * @description
 */
public class Solution00958 {
    /**
     * DFS
     *
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right != null) return false;

        return isCompleteTree(root.left) && isCompleteTree(root.right);
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public boolean isCompleteTreeBfs(TreeNode root) {
        return true;
    }
}
