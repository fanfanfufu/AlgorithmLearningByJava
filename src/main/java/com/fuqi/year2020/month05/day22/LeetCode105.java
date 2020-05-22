package com.fuqi.year2020.month05.day22;

import com.fuqi.year2020.TreeNode;

import java.util.Stack;

/**
 * @Description:
 * @Author 傅琦
 * @date 2020/5/22 10:01
 * @Version V1.0
 */
public class LeetCode105 {
    /**
     * 方法一：递归
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        // 终止条件
        if (preorder.length == 0 && preorder.length == 0){ return null; }
        if (preorder.length == 1 && inorder.length == 1){ return new TreeNode(preorder[0]); }
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        while (i < inorder.length){
            if (preorder[0] == inorder[i]){
                break;
            }
            i++;
        }
        // 左子树的前序和中序遍历
        int[] leftpreOrder = new int[i];
        int[] leftinOrder = new int[i];
        System.arraycopy(preorder, 1, leftpreOrder, 0, i);
        System.arraycopy(inorder, 0, leftinOrder, 0, i);
        // 右子树的前序和中序遍历
        int rightLen = inorder.length - i - 1;
        int[] rightpreOrder = new int[rightLen];
        int[] rightinOrder = new int[rightLen];
        System.arraycopy(preorder, i+1, rightpreOrder, 0, rightLen);
        System.arraycopy(inorder, i+1, rightinOrder, 0, rightLen);
        // 递归构造当前节点的左右子树
        root.left = buildTree1(leftpreOrder, leftinOrder);
        root.right = buildTree1(rightpreOrder, rightinOrder);
        return root;
    }

    /**
     * 方法二：迭代
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0){ return null; }

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preOrderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]){
                node.left = new TreeNode(preOrderVal);
                stack.push(node.left);
            }else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]){
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preOrderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
