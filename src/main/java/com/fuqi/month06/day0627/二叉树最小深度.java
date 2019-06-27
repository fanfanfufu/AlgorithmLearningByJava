package com.fuqi.month06.day0627;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/6/27 9:39
 * @Version V1.0
 */
public class 二叉树最小深度 {
    /**
     * 迭代法
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        int depth = 0;
        if (root == null){ return depth; }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null){
                    return depth+1;
                }
                if (cur.left != null){ queue.offer(cur.left); }
                if (cur.right != null){ queue.offer(cur.right); }
            }
            depth++;
        }

        return depth;
    }

    /**
     * 递归法
     */
    public int minDepth2(TreeNode root){
        if (root == null){ return 0; }

        if (root.left == null && root.right == null){ return 1; }

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null){
            minDepth = Math.min(minDepth2(root.left), minDepth);
        }
        if (root.right != null){
            minDepth = Math.min(minDepth2(root.right), minDepth);
        }

        return minDepth+1;
    }
}
