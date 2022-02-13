package com.fuqi.year2022.month02;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/2/13 20:19
 * @description
 */
public class Solution00572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSameTree(root, subRoot);
    }

    /**
     * 判断两棵树是否相等
     *
     * @param s
     * @param t
     * @return
     */
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
