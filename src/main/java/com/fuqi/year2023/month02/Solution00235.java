package com.fuqi.year2023.month02;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2023/2/10 22:47
 * @description 寻找二叉树任意两个节点的最近公共祖先
 */
public class Solution00235 {
    /**
     * 思路：
     * 1. 题目给定的是二叉搜索树
     * 2. 对于单层递归逻辑而言：
     * 2.1 当p/q都严格小于当前的root时，那么p/q的公共祖先必然在当前root的左子树中
     * 2.2 当p/q都严格大于当前的root时，p/q的公共祖先必然再当前root的右子树中
     * 2.3 不满足前面两种情况的：
     * 2.3.1 root == p/q中的任意一个
     * 2.3.2 root在p,q中间
     * 那么p,q的公共祖先就一定是root
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
