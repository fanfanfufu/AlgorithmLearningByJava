package com.fuqi.month05.day0524;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @Author 傅琦
 * @Date 2019/5/24 9:32
 * @Version V1.0
 */
public class IsSymmetrical {

    public boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null){
            return true;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(pRoot.left);
        treeNodeQueue.offer(pRoot.right);
        while (!treeNodeQueue.isEmpty()){
            TreeNode rightNode = treeNodeQueue.poll();
            TreeNode leftNode = treeNodeQueue.poll();

            if (leftNode == null && rightNode == null){continue;}
            if (leftNode == null || rightNode == null){return false;}
            if (leftNode.val != rightNode.val){return false;}

            treeNodeQueue.offer(leftNode.left);
            treeNodeQueue.offer(rightNode.right);
            treeNodeQueue.offer(leftNode.right);
            treeNodeQueue.offer(rightNode.left);
        }

        return true;
    }
}

class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val){
        this.val = val;
    }
}
