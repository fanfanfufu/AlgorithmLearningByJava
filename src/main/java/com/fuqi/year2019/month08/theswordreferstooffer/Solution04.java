package com.fuqi.year2019.month08.theswordreferstooffer;

/**
 * @Description: 重建二叉树
 * @Author 傅琦
 * @date 2019/8/7 10:55
 * @Version V1.0
 */
public class Solution04 {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        if ((pre.length != in.length) || (pre.length == 0 && in.length == 0)){
            return null;
        }
        return btConstruct(pre, in);
    }

    /**
     * 递归构建二叉树
     * @param preOrder 前序遍历数组
     * @param inOrder 中序遍历数组
     * @return TreeNode
     */
    private TreeNode btConstruct(int[] preOrder, int[] inOrder){
        // 根节点一定是原始前序数组的第一个元素
        TreeNode tree = new TreeNode(preOrder[0]);
        if (preOrder.length <= 1 && inOrder.length <= 1){
            return tree;
        }

        int inOrderRootLocation = 0;
        // 找出根节点在中序数组中的位置
        for (int i = 0; i < inOrder.length; i++) {
            if (preOrder[0] == inOrder[i]){
                inOrderRootLocation = i;
            }
        }

        int leftTreeLength = inOrderRootLocation;
        int rightTreeLength = inOrder.length - inOrderRootLocation - 1;
        // 将中序遍历的左右子树复制到新的数组
        int[] leftTreeInOrder = new int[leftTreeLength];
        int[] rightTreeInOrder = new int[rightTreeLength];
        System.arraycopy(inOrder, 0, leftTreeInOrder, 0, leftTreeLength);
        System.arraycopy(inOrder, inOrderRootLocation+1, rightTreeInOrder, 0, rightTreeLength);

        // 复制先序遍历中的左右子树各自部分到新的数组
        int[] leftTreePreOrder = new int[leftTreeLength];
        int[] rightTreePreOrder = new int[rightTreeLength];
        System.arraycopy(preOrder, 1, leftTreePreOrder, 0, leftTreeLength);
        System.arraycopy(preOrder, leftTreeLength+1, rightTreePreOrder, 0, rightTreeLength);

        // 递归构建左右子树
        if (leftTreeLength > 0){
            tree.left = btConstruct(leftTreePreOrder, leftTreeInOrder);
        }
        if (rightTreeLength > 0){
            tree.right = btConstruct(rightTreePreOrder, rightTreeInOrder);
        }

        return tree;
    }
}
