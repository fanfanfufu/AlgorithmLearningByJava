package com.fuqi.year2022.month08;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/8/20 20:31
 * @description
 */
public class Solution00226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }
}
