package com.fuqi.year2023.month08;

import com.fuqi.year2020.TreeNode;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/25 22:31
 * @description
 */
public class Solution01448 {
    /**
     * 递归处理，并且沿路径比较并更新路径上的最大值
     * 当前节点只要大于等于路径上的最大值，就大于路径上的所有节点的值，就是1个好节点
     *
     * @param root 根结点
     * @return 好节点个数
     */
    public int goodNodes(TreeNode root) {
        // 特殊情况的判断处理
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        // 递归计算左右子树的好节点个数
        int leftCount = dfs(root.left, root.val);
        int rightCount = dfs(root.right, root.val);

        // 返回左右子树的好节点个数，再加上根结点的个数
        return leftCount + rightCount + 1;
    }

    private int dfs(TreeNode node, int preMax) {
        // 空节点返回0
        if (node == null) return 0;
        // 如果当前节点为叶子节点
        if (node.left == null && node.right == null) {
            // 并且当前节点的值小于路径中的最大值，则返回0，否则返回1
            if (node.val < preMax) return 0;
            return 1;
        }
        // 当前节点为非叶子节点
        int ans = 0;
        if (node.val >= preMax) {
            // 判断当前节点是否大于路径中的最大值，
            // 是的话，当前节点是一个好节点，结果+1，并且更新路径中的最大值
            ans++;
            preMax = node.val;
        }
        // 递归处理左右子树
        ans += dfs(node.left, preMax);
        ans += dfs(node.right, preMax);

        return ans;
    }
}
