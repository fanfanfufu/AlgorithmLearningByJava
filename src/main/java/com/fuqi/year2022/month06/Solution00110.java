package com.fuqi.year2022.month06;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/6/26 22:14
 * @description 判断平衡二叉树
 */
public class Solution00110 {
    /**
     * 自顶向下的方法
     * 时间复杂度
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height1(root.left) - height1(root.right)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
        }
    }

    private int height1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height1(root.left), height1(root.right)) + 1;
        }
    }

    public boolean isBalanced2(TreeNode root) {
        return height2(root) >= 0;
    }

    private int height2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
