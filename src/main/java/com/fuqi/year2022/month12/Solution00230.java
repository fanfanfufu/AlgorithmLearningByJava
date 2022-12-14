package com.fuqi.year2022.month12;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/12/14 23:26
 * @description 找出二叉搜索树的第k小节点
 */
public class Solution00230 {
    private int ans = 0;
    private int index = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.left, k);
        index++;
        if (index == k) {
            ans = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
