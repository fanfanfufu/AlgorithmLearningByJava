package com.fuqi.year2022.month11;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/11/14 23:15
 * @description
 */
public class Offer36 {
    TreeNode head, pre;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        dfs(root);
        head.left = pre;
        pre.right = head;

        return head;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (pre == null) {
            head = node;
            pre = head;
        } else {
            pre.right = node;
            node.left = pre;
            pre = node;
        }
        dfs(node.right);
    }

}
