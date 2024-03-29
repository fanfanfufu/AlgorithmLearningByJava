package com.fuqi.year2020;

/**
 * @Description: 二叉树
 * @Author: 傅琦
 * @DateTime: 2020/5/10 11:00
 * @Version: V1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int x){
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
