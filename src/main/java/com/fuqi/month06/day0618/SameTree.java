package com.fuqi.month06.day0618;

/**
 * @Description: 判断两棵二叉树是否相同
 * @Team 电子科技大学自动化研究所
 * @Author 傅琦
 * @Date 2019/6/18 11:23
 * @Version V1.0
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null){
            if (p.val != q.val){
                return false;
            }
        }
        if (p == null && q == null){return true;}
        if ((p != null && q == null) || (p == null && q != null)){return false;}

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
}
