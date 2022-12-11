package com.fuqi.year2022.month12;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/12/11 15:28
 * @description
 */
public class Solution00450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        // 第三种情况，root.val == key
        if (root.left == null && root.right == null) {
            // 当前root是叶子节点，则直接删除，返回null即可
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        // 如果root节点的左右子树都不为空
        // 1. 找到root节点右子树的最左节点作为新的root节点
        TreeNode newRoot = root.right;
        while (newRoot.left != null) {
            newRoot = newRoot.left;
        }
        // 2. 删除新的root节点在当前root节点的右子树中的位置
        root.right = deleteNode(root.right, newRoot.val);
        // 3. 设置新节点的左右子树
        newRoot.left = root.left;
        newRoot.right = root.right;

        return newRoot;
    }
}
