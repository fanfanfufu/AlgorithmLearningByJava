package com.fuqi.year2023.month01;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2023/1/2 21:24
 * @description 判断树的子结构，不是判断是否是子树
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (a == null || b == null) return false;

        return isSubStructure(a.left, b) || isSubStructure(a.right, b) || recur(a, b);
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || a.val != b.val) return false;

        return recur(a.left, b.left) && recur(a.right, b.right);
    }
}
