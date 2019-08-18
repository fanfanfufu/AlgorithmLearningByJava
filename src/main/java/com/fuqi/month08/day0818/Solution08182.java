package com.fuqi.month08.day0818;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/8/18 11:01
 * @Version: V1.0
 */
public class Solution08182 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int layerNumber = 1;
        int ans = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE;

        while (!queue.isEmpty()){
            int tempSize = queue.size();
            int tempSum = 0;
            for (int i = 0; i < tempSize; i++) {
                TreeNode cur = queue.poll();
                tempSum += cur.val;
                // 按层添加节点
                if (cur.left != null) { queue.offer(cur.left); }
                if (cur.right != null) { queue.offer(cur.right); }
            }
            if (tempSum > maxSum){
                maxSum = tempSum;
                ans = layerNumber;
            }
            layerNumber++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution08182 solution08182 = new Solution08182();
        TreeNode root = solution08182.new TreeNode(989);
        root.right = solution08182.new TreeNode(10250);
    }
}
