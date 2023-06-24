package com.fuqi.year2022.month06;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/6/18 19:49
 * @description
 */
public class Solution00124 {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum1(TreeNode root) {
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

    /**
     * 只适合从头节点出发
     *
     * @param root
     * @return
     */
    public int maxPathSum2(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;

        int subMax = Integer.MIN_VALUE;
        if (root.left != null) subMax = maxPathSum2(root.left);
        if (root.right != null) subMax = Math.max(subMax, maxPathSum2(root.right));

        return subMax + root.val;
    }
}
