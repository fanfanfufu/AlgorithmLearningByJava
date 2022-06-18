package com.fuqi.year2022.month06;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/6/18 19:49
 * @description
 */
public class Solution00124 {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);

        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);

        int maxPath = root.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, maxPath);

        return root.val + Math.max(leftGain, rightGain);
    }
}
