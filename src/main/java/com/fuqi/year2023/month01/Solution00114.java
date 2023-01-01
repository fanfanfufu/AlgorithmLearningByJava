package com.fuqi.year2023.month01;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2023/1/1 21:33
 * @description 二叉树展开位单链表
 */
public class Solution00114 {
    /**
     * 本题最简单的解法就是按照先序遍历取出各个节点放入一个数组，
     * 然后再按照题意拼接成单链表。 时间复杂度为O(n)，空间复杂度为O(n)
     *
     * 进阶：空间复杂度为O(1)的思路
     *
     * @param root
     */
    public void flatten1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        // 如果左子树为空，则递归处理右子树
        if (root.left == null) {
            flatten1(root.right);
            return;
        }
        // 如果左子树不为空，则先递归处理左子树
        flatten1(root.left);
        // 走到左子树的最后一个节点
        TreeNode cur = root.left;
        while (cur != null && cur.right != null) cur = cur.right;
        // 递归处理右子树
        flatten1(root.right);
        // 将左子树的最后一个节点指向右子树
        cur.right = root.right;
        // 将左子树替换为右子树
        root.right = root.left;
        // 将左子树置空
        root.left = null;
    }

    /**
     * 递归思路的代码优化
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        // 按照先序遍历的递归处理处理左右子树，将左右子树处理成单链表
        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right;
        // 将左子树替换到原来右子树的位置，然后置空左子树
        root.right = root.left;
        root.left = null;
        // 遍历非空链表走到最后一个节点
        while (root.right != null) root = root.right;
        // 将展开后的右子树接上去
        root.right = temp;
    }
}
