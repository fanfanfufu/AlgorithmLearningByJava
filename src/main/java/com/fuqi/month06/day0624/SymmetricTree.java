package com.fuqi.month06.day0624;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 判断一个二叉树是否是对称二叉树
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * true
 *
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * false
 *
 * @Author 傅琦
 * @date 2019/6/24 9:02
 * @Version V1.0
 */
public class SymmetricTree {
    /**
     * 递归：时间复杂度O(n)
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        }

        if (t1 == null || t2 == null){
            return false;
        }

        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    /**
     * 迭代的方式：时间复杂度O(n)
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null){ continue; }
            if (t1 == null || t2 == null){ return false; }
            if (t1.val != t2.val){ return false; }
            // 添加的时候要成对添加
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }

        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
