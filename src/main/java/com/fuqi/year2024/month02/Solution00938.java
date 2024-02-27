package com.fuqi.year2024.month02;

import com.fuqi.year2020.TreeNode;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/2/26 21:33
 * @description
 */
public class Solution00938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val > high) return rangeSumBST(root.left, low, high);
        if (root.val < low) return rangeSumBST(root.right, low, high);

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
