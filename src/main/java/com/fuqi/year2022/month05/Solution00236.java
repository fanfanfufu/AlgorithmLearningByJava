package com.fuqi.year2022.month05;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/5/28 21:33
 * @description
 */
public class Solution00236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;
    }

    /**
     * 判断一个节点是否在树中
     *
     * @param root
     * @param target
     * @return
     */
    private boolean judge(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val != target.val) {
            return false;
        }

        if (root.val == target.val) {
            return true;
        }

        return judge(root.left, target) || judge(root.right, target);
    }
}
