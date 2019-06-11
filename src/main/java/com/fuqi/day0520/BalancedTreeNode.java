package com.fuqi.day0520;

/**
 * @Description: 判断平衡二叉树
 * @Author 傅琦
 * @Date 2019/5/20 21:06
 * @Version V1.0
 */
public class BalancedTreeNode {
    private boolean isBalanced = false;

    public boolean IsBalanced_Solution(TreeNode root) {
        int depth = getDepth(root);
        return isBalanced;
    }

    public int getDepth(TreeNode root){
        if(root == null){
            isBalanced = true;
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if(Math.abs(left - right) <= 1) {
            isBalanced = true;
        } else {
            isBalanced = false;
        }

        return left>right ? (left+1):(right+1);
    }
}

class TreeNode{
    int leftValue;
    int rightValue;
    TreeNode left;
    TreeNode right;

    TreeNode(int value1, int value2){
        leftValue = value1;
        rightValue = value2;
    }
}
