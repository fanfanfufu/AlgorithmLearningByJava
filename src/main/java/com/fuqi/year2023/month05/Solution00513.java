package com.fuqi.year2023.month05;

import com.fuqi.year2020.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/8 21:37
 * @description
 */
public class Solution00513 {
    /**
     * 先让右子节点入队，再让左子节点入队，实现从右向左的层序遍历
     * 最后的那个节点就是题目所要的最后一层最左边的节点
     *
     * @param root 根节点
     * @return int
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.offerLast(root);
        TreeNode ans = new TreeNode(0);
        while (!nodeDeque.isEmpty()) {
            ans = nodeDeque.pollFirst();
            if (ans.right != null) nodeDeque.offerLast(ans.right);
            if (ans.left != null) nodeDeque.offerLast(ans.left);
        }

        return ans.val;
    }
}
