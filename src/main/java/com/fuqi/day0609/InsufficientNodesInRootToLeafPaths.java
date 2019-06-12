package com.fuqi.day0609;

import java.util.LinkedList;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/6/9 11:38
 * @Version: V1.0
 */
public class InsufficientNodesInRootToLeafPaths {
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(-99);
//        treeNode.right = new TreeNode(-99);

        System.out.println(treeNode.left == treeNode.right);

        TreeNode res = sufficientSubset(treeNode, 1);
        System.out.println(res.val);
    }

    private static TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root.left == root.right)
            // 如果当前节点的左子树和右子树都为空，则根据当前限制判断是否删除该节点
            return root.val < limit ? null : root;
        if (root.left != null)
            root.left = sufficientSubset(root.left, limit - root.val);
        if (root.right != null)
            root.right = sufficientSubset(root.right, limit - root.val);
        return root.left == root.right ? null : root;
    }

    private static void laywerTraversal(TreeNode root){
        if(root==null) {return;}
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        TreeNode currentNode;
        while(!list.isEmpty()){
            currentNode=list.poll();
            System.out.println(currentNode.val);
            if(currentNode.left!=null){
                list.add(currentNode.left);
            }
            if(currentNode.right!=null){
                list.add(currentNode.right);
            }
        }
    }
}


class TreeNode extends Object{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
