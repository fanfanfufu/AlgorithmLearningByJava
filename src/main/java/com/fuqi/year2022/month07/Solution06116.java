package com.fuqi.year2022.month07;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/7/9 22:39
 * @description
 */
public class Solution06116 {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) {
            return root.val == 1;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2) {
            return left || right;
        }

        return left && right;
    }
}
