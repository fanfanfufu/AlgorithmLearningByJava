package com.fuqi.year2022.month11;

import com.fuqi.year2020.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/11/23 22:20
 * @description 二叉树后序遍历
 */
public class Solution00145 {
    /**
     * 后续遍历：左右父
     *
     * @param root 顶点
     * @return list
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, ans);

        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }
}
