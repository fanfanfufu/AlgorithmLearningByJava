package com.fuqi.year2022;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/8/12 23:20
 * @description
 */
public class Solution00098 {
    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }

        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, upper);
    }

    /**
     * 借助中序遍历
     * 二叉搜索树的中序遍历就是一个严格单调递增的序列
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        return inorder(root);
    }

    /**
     * 这里必须要用全局变量
     * 如果用局部变量，在：
     *       1
     *     /
     *   1
     *  这种结构的时候会在左节点递归后，pre并未得到修改，所以会导致root节点使用的pre是Long.MIN_VALUE，从而得到true的结果
     *  而使用全局变量，则很好的规避了这种问题
     */
    private long pre = Long.MIN_VALUE;
    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = inorder(root.left);
        if (root.val <= pre) {
            // 如果当前节点的值小于或者等于前一个节点
            return false;
        }
        pre = root.val;
        boolean right = inorder(root.right);

        return left && right;
    }
}
