package com.fuqi.treelearn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 二叉树的最大深度
 * @Team 电子科技大学自动化研究所
 * @Author 傅琦
 * @date 2019/7/26 10:54
 * @Version V1.0
 */
public class TreeDepth {
    int ans;

    public int maxDepth(TreeNode root) {
        if (root == null){ return 0; }

        helper1(root, 1);
        return ans;
    }

    /**
     * 方法一：自顶向下
     * @param root
     * @param depth
     * @return int
     */
    public void helper1(TreeNode root, int depth) {

        ans = Math.max(ans, depth);

        if (root.left != null){
            helper1(root.left, depth + 1);
        }

        if (root.right != null){
            helper1(root.right, depth + 1);
        }
    }

    /**
     * 方法二：自底向上
     */
    public int helper2(TreeNode root){
        int leftDepth = 0, rightDepth = 0;
        if (root.left != null){
            leftDepth = helper2(root.left);
        }

        if (root.right != null){
            rightDepth = helper2(root.right);
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 方法三：按层遍历，数层数即可
     * @param root
     * @return
     */
    public int helper3(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null){ queue.offer(cur.left); }
                if (cur.right != null){ queue.offer(cur.right); }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeDepth td = new TreeDepth();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);

        int res = td.helper3(root);
        System.out.println("res = " + res);
    }
}
