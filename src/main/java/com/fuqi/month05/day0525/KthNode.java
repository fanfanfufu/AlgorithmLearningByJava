package com.fuqi.month05.day0525;

/**
 * @Description: 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 * @Author 傅琦
 * @Date 2019/5/25 10:22
 * @Version V1.0
 */
public class KthNode {

    /**
     * 中序递归
     */
    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null){
            return null;
        }

        TreeNode left = KthNode(pRoot.left, k);
        if (left != null){ return left; }

        index++;

        if (index == k){ return pRoot; }

        TreeNode right = KthNode(pRoot.right, k);

        if (right != null){return right;}

        return null;
    }

    /**
     * 先中序遍历，节点放入List中，再取k-1处的节点
     */
}