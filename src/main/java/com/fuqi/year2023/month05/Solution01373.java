package com.fuqi.year2023.month05;

import com.fuqi.year2020.TreeNode;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/20 19:27
 * @description 1373. 二叉搜索子树的最大键值和
 */
public class Solution01373 {
    private int ans;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        
        return ans;
    }

    /**
     * 每棵子树返回：
     * 这棵子树的最小节点值。
     * 这棵子树的最大节点值。
     * 这棵子树的所有节点值之和。
     *
     * @param root
     * @return
     */
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int x = root.val;

        if (x <= left[1] || x >= right[0]) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int sum = left[2] + right[2] + x;
        ans = Math.max(ans, sum);

        return new int[]{Math.min(left[0], x), Math.max(right[1], x), sum};
    }
}
