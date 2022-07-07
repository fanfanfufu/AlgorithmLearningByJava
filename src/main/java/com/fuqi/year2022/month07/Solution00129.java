package com.fuqi.year2022.month07;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/7/8 0:00
 * @description
 */
public class Solution00129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int curSum = preSum*10 + root.val;
        if (root.left == null && root.right == null) {
            return curSum;
        } else {
            return dfs(root.left, curSum) + dfs(root.right, curSum);
        }
    }
}
