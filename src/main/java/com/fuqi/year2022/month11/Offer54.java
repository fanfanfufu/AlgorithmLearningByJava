package com.fuqi.year2022.month11;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/11/21 21:58
 * @description 找出二叉搜索树的第k大节点
 */
public class Offer54 {
    int ans;
    int index = 0;
    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.right, k);
        index++;
        if (k == index) ans = root.val;
        dfs(root.left, k);
    }
}
