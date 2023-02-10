package com.fuqi.year2022.month05;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/5/28 21:33
 * @description
 */
public class Solution00236 {
    /**
     * 思路：
     * 1. 判断p/q是否再root.left中，通过p/q的值与遍历到的node的值比较，相等则返回对应的node
     * 2. 再判断p/q是否在root.right中
     * 3. 如果步骤1满足，2不满足，则说明最近的公共节点为root.left
     * 4. 如果步骤2满足，1不满足，则说明最近的公共节点为root.right
     * 5. 如果1，2同时满足，说明左右子树各有一个节点，因此最近的公共祖先就是当前的root
     *
     * 递归终止：
     * 1. root == null
     * 2. root.val == p.val || root.val == q.val
     *
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
