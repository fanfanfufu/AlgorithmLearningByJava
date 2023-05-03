package com.fuqi.year2023.month05;

import com.fuqi.year2020.TreeNode;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/3 16:46
 * @description
 */
public class Solution00100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // same null
        if (p == null && q == null) return true;
        // one null, another not null
        if (p == null || q == null) return false;
        // value not equal
        if (p.val != q.val) return false;

        // judge the subtree
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
